package apap.tugas1.sipas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="diagnosis_penyakit")
public class DiagnosisPenyakitModel implements Serializable {
    @Id
    //@Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    public String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "kode", nullable = false)
    public String kode;

    // Relationship Pasien - Diagnosis Penyakit
    @OneToMany(mappedBy = "diagnosisPenyakit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<PasienDiagnosisPenyakitModel> listDiagnosisPenyakitPasien;

    public Long getIdDiagnosisPenyakit() {
        return id;
    }

    public void setIdDiagnosisPenyakit(Long idDiagnosisPenyakit) {
        this.id = id;
    }

    public String getNamaDiagnosisPenyakit() {
        return nama;
    }

    public void setNamaDiagnosisPenyakit(String namaDiagnosisPenyakit) {
        this.nama = nama;
    }

    public String getKodePenyakit() {
        return kode;
    }

    public void setKodePenyakit(String kodePenyakit) {
        this.kode = kode;
    }

    public List<PasienDiagnosisPenyakitModel> getListDiagnosisPenyakitPasien() {
        return listDiagnosisPenyakitPasien;
    }

    public void setListDiagnosisPenyakitPasien(List<PasienDiagnosisPenyakitModel> listDiagnosisPenyakitPasien) {
        this.listDiagnosisPenyakitPasien = listDiagnosisPenyakitPasien;
    }
}