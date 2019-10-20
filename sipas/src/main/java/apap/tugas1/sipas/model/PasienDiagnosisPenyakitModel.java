package apap.tugas1.sipas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="pasien_diagnosis_penyakit")
public class PasienDiagnosisPenyakitModel implements Serializable {
    @Id
    //@Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // Relationship Pasien - Diagnosis Penyakit
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPasien", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public PasienModel pasienDiagnosis;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idDiagnosisPenyakit", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public DiagnosisPenyakitModel diagnosisPenyakit;

    @NotNull
    @Column(name = "tanggalDiagnosis", nullable = false)
    public Date tanggalDiagnosis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggalDiagnosis() {
        return tanggalDiagnosis;
    }

    public void setTanggalDiagnosis(Date tanggalDiagnosis) {
        this.tanggalDiagnosis = tanggalDiagnosis;
    }
}
