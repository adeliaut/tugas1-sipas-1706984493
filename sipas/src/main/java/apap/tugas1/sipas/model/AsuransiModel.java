package apap.tugas1.sipas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="asuransi")
public class AsuransiModel implements Serializable {
    @Id
    @Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    public String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "jenis", nullable = false)
    public String jenis;

    // Relationship Pasien - Asuransi
    @OneToMany(mappedBy = "asuransi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PasienAsuransiModel> listAsuransiPasien;

    public Long getIdAsuransi() {
        return id;
    }

    public void setIdAsuransi(Long idAsuransi) {
        this.id = id;
    }

    public String getNamaAsuransi() {
        return nama;
    }

    public void setNamaAsuransi(String namaAsuransi) {
        this.nama = nama;
    }

    public String getJenisAsuransi() {
        return jenis;
    }

    public void setJenisAsuransi(String jenisAsuransi) {
        this.jenis = jenis;
    }

    public List<PasienAsuransiModel> getListAsuransiPasien() {
        return listAsuransiPasien;
    }

    public void setListAsuransiPasien(List<PasienAsuransiModel> listAsuransiPasien) {
        this.listAsuransiPasien = listAsuransiPasien;
    }
}
