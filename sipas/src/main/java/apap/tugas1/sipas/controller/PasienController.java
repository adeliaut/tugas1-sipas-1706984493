package apap.tugas1.sipas.controller;

import apap.tugas1.sipas.model.AsuransiModel;
import apap.tugas1.sipas.model.DiagnosisPenyakitModel;
import apap.tugas1.sipas.model.EmergencyContactModel;
import apap.tugas1.sipas.model.PasienModel;
import apap.tugas1.sipas.service.AsuransiService;
import apap.tugas1.sipas.service.DiagnosisPenyakitService;
import apap.tugas1.sipas.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PasienController {
    @Qualifier("pasienServiceImpl")

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    @Autowired
    private AsuransiService asuransiService;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String beranda(Model model) {
        List<PasienModel> listPasien = pasienService.getPasienList();
        model.addAttribute("pasien", listPasien);
        return "beranda";
    }

    // Menambah Pasien
    @RequestMapping(value = "/pasien/tambah", method = RequestMethod.GET)
    public String tambahPasienForm(Model model) {
        PasienModel pasienBaru = new PasienModel();

        // Menampilkan dropdown asuransi
        List<AsuransiModel> listAsuransi = asuransiService.getAsuransiList();

        model.addAttribute("asuransi", listAsuransi);
        model.addAttribute("pasien", pasienBaru);
        return "form-tambah-pasien";
    }

    @RequestMapping(value = "/pasien/tambah", method = RequestMethod.POST)
    public String tambahPasienSubmit(@ModelAttribute PasienModel pasien, Model model) {
        pasienService.tambahPasien(pasien);

        model.addAttribute("namaPasien", pasien.getNamaPasien());
        model.addAttribute("kodePasien", pasien.getKodePasien());
        return "tambah-pasien";
    }

    // Menampilkan Data Pasien Berdasarkan NIK Pasien
    @RequestMapping(path = "/pasien", method = RequestMethod.GET)
    public String viewPasienByNik (
            @RequestParam(value = "nikPasien", required = true) String nikPasien,
            Model model
            ) {
        PasienModel dataPasien = pasienService.getPasienByNik(nikPasien);

        model.addAttribute("pasien", dataPasien);
        return "data-pasien";
    }

    // Mengubah Pasien Berdasarkan NIK Pasien
    @RequestMapping(value = "/pasien/ubah/{nikPasien}", method = RequestMethod.GET)
    public String ubahPasienFormPage(@PathVariable String nikPasien, Model model) {
        PasienModel dataSekarang = pasienService.getPasienByNik(nikPasien);
        model.addAttribute("pasien", dataSekarang);
        return "form-ubah-pasien";
    }

    @RequestMapping(value="/pasien/ubah/{nikPasien}", method=RequestMethod.POST)
    public String ubahPasien(@PathVariable String nikPasien, @ModelAttribute PasienModel pasien, Model model) {
        PasienModel dataBaru = pasienService.ubahPasien(pasien);
        model.addAttribute("pasien", dataBaru);
        return "ubah-pasien";
    }

    // Menambah Diagnosis Penyakit Pasien
    @RequestMapping(value = "/pasien/{nikPasien}/tambah-diagnosis", method = RequestMethod.GET)
    public String tambahDiagnosisPenyakitPasienForm(@PathVariable String nikPasien, Model model) {
        PasienModel pasienBaru = new PasienModel();

        // Menampilkan dropdown diagnosis penyakit
        List<DiagnosisPenyakitModel> listDiagnosisPenyakit = diagnosisPenyakitService.getDiagnosisPenyakitList();

        PasienModel dataPasien = pasienService.getPasienByNik(nikPasien);

        model.addAttribute("diagnosis", listDiagnosisPenyakit);
        model.addAttribute("pasien", dataPasien);
        return "form-tambah-diagnosis-penyakit-pasien";
    }

    @RequestMapping(value = "/pasien/{nikPasien}/tambah-diagnosis", method = RequestMethod.POST)
    public String tambahDiagnosisPenyakitPasienSubmit(@ModelAttribute PasienModel pasien, Model model) {
        pasienService.tambahPasien(pasien);

        model.addAttribute("namaPasien", pasien.getNamaPasien());
        model.addAttribute("kodePasien", pasien.getKodePasien());
        return "tambah-diagnosis-penyakit-pasien";
    }


}
