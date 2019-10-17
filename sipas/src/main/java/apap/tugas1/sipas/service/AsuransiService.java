package apap.tugas1.sipas.service;

import apap.tugas1.sipas.model.AsuransiModel;

import java.util.List;
import java.util.Optional;

public interface AsuransiService {
    List<AsuransiModel> getAsuransiList();
    //Optional<AsuransiModel> getAsuransiById(Long id);

}
