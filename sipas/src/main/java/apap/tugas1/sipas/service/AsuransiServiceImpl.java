package apap.tugas1.sipas.service;

import apap.tugas1.sipas.model.AsuransiModel;
import apap.tugas1.sipas.repository.AsuransiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AsuransiServiceImpl implements AsuransiService {
    @Autowired
    private AsuransiDb asuransiDb;

    @Override
    public List<AsuransiModel> getAsuransiList() {
        return asuransiDb.findAll();
    }



}