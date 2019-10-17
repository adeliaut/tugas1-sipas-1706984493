package apap.tugas1.sipas.repository;

import apap.tugas1.sipas.model.AsuransiModel;
import apap.tugas1.sipas.model.PasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsuransiDb extends JpaRepository<AsuransiModel, Long> {
    //Optional<AsuransiModel> findById(Long id);

}