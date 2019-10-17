package apap.tugas1.sipas.controller;

import apap.tugas1.sipas.model.DiagnosisPenyakitModel;
import apap.tugas1.sipas.service.DiagnosisPenyakitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DiagnosisPenyakitController {
    @Qualifier("diagnosisPenyakitServiceImpl")

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    // Menampilkan Daftar Diagnosis Penyakit
    @RequestMapping(path="/diagnosis-penyakit-all", method = RequestMethod.GET)
    public String viewDiagnosisPenyakit(Model model) {
        List<DiagnosisPenyakitModel> listDiagnosisPenyakit = diagnosisPenyakitService.getDiagnosisPenyakitList();
        model.addAttribute("diagnosisPenyakit", listDiagnosisPenyakit);
        return "diagnosis-penyakit-all";
    }

    // Menampilkan Data Diagnosis Penyakit Berdasarkan id
    @RequestMapping(path = "/diagnosis-penyakit", method = RequestMethod.GET)
    public String viewDiagnosisById (
            @RequestParam(value = "idDiagnosis", required = true) Long idDiagnosis,
            Model model
    ) {
        DiagnosisPenyakitModel dataDiagnosisPenyakit =
                diagnosisPenyakitService.getDiagnosisPenyakitById(idDiagnosis).get();

        model.addAttribute("diagnosis", dataDiagnosisPenyakit);
        return "diagnosis-penyakit";
    }

    // Tambah Diagnosis Penyakit
    @RequestMapping(value = "/diagnosis-penyakit/tambah", method = RequestMethod.GET)
    public String tambahDiagnosisPenyakitForm(Model model) {
        DiagnosisPenyakitModel diagnosisBaru = new DiagnosisPenyakitModel();
        model.addAttribute("diagnosis", diagnosisBaru);
        return "form-tambah-diagnosis-penyakit";
    }

    @RequestMapping(value = "/diagnosis-penyakit/tambah", method = RequestMethod.POST)
    public String tambahDiagnosisPenyakitSubmit(@ModelAttribute DiagnosisPenyakitModel diagnosis, Model model) {
        diagnosisPenyakitService.tambahDiagnosis(diagnosis);
        return "tambah-diagnosis-penyakit";
    }

    // Menghapus Diagnosis Penyakit Berdaarkan id
    @RequestMapping("/diagnosis-penyakit/hapus/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model){
        diagnosisPenyakitService.hapusDiagnosisPenyakit(id);
        model.addAttribute("diagnosis", id);
        return "hapus-diagnosis-penyakit";
    }
}
