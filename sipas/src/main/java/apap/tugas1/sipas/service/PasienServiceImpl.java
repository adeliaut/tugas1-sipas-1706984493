package apap.tugas1.sipas.service;

import apap.tugas1.sipas.model.EmergencyContactModel;
import apap.tugas1.sipas.model.PasienModel;
import apap.tugas1.sipas.repository.PasienDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
    @Autowired
    private PasienDb pasienDb;

    @Override
    public List<PasienModel> getPasienList() {
        return pasienDb.findAll();
    }

    @Override
    public void tambahPasien(PasienModel pasien) {
        pasienDb.save(pasien);
    }

    @Override
    public PasienModel getPasienByNik(String nik) {
        return pasienDb.findByNik(nik);
    }

    @Override
    public PasienModel ubahPasien(PasienModel pasienModel) {
        try {
            PasienModel dataUbah = pasienDb.findByNik(pasienModel.getNikPasien());
            dataUbah.setNamaPasien(pasienModel.getNamaPasien());
            dataUbah.setNikPasien(pasienModel.getNikPasien());
            dataUbah.setJenisKelamin(pasienModel.getJenisKelamin());
            dataUbah.setTanggalLahir(pasienModel.getTanggalLahir());
            /**
             * TO DO
             * field Emergency Contact Name
             * field Emergency Contact NIK
             * field Emergency Contact Phone
             * */
            pasienDb.save(dataUbah);
            return dataUbah;
        } catch (NullPointerException nullException) {
            return null;
        }
    }
}
