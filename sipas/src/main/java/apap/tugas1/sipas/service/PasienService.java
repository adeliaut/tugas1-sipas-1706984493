package apap.tugas1.sipas.service;

import apap.tugas1.sipas.model.EmergencyContactModel;
import apap.tugas1.sipas.model.PasienModel;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PasienService {
    List<PasienModel> getPasienList();
    void tambahPasien(PasienModel pasien);
    PasienModel getPasienByNik(String nik);
    PasienModel ubahPasien(PasienModel pasienModel);
}