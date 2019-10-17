package apap.tugas1.sipas.service;

import apap.tugas1.sipas.model.DiagnosisPenyakitModel;

import java.util.List;
import java.util.Optional;

public interface DiagnosisPenyakitService {
    List<DiagnosisPenyakitModel> getDiagnosisPenyakitList();
    Optional<DiagnosisPenyakitModel> getDiagnosisPenyakitById(Long id);
    void tambahDiagnosis(DiagnosisPenyakitModel diagnosis);
    void hapusDiagnosisPenyakit(Long id);
}
