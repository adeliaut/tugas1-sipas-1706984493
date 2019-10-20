package apap.tugas1.sipas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pasien")
public class PasienModel implements Serializable {
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

    @NotNull
    @Size(max = 255)
    @Column(name = "nik", nullable = false)
    public String nik;

    @NotNull
    @Column(name = "tanggalLahir", nullable = false)
    public Date tanggalLahir;

    @NotNull
    @Size(max = 255)
    @Column(name = "tempatLahir", nullable = false)
    public String tempatLahir;

    @NotNull
    @Column(name = "jenisKelamin", nullable = false)
    public Integer jenisKelamin;

    /*@NotNull
    @Size(max = 20)
    @Column(name = "idEmergencyContact", nullable = false)
    public BigInteger idEmergencyContact;*/

    // Relationship Pasien - Diagnosis Penyakit
    @OneToMany(mappedBy = "pasienDiagnosis", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<PasienDiagnosisPenyakitModel> listPasienPenyakitDiagnosis;

    // Relationship Pasien - Asuransi
    @OneToMany(mappedBy = "pasienAsuransi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<PasienAsuransiModel> listPasienAsuransi;

    // Relationship Pasien - Emergency Contact
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idEmergencyContact", referencedColumnName ="id")
    public EmergencyContactModel emergencyContact;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNamaPasien(String nama) {
        this.nama = nama;
    }

    public String getNamaPasien() {
        return nama;
    }

    public void setKodePasien(String kode) {
        this.kode = kode;
    }

    public String getKodePasien() {
        return kode;
    }

    public void setNikPasien(String nik) {
        this.nik = nik;
    }

    public String getNikPasien() {
        return nik;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    /*public BigInteger getIdEmergencyContact() {
        return idEmergencyContact;
    }

    public void setIdEmergencyContact(BigInteger idEmergencyContact) {
        this.idEmergencyContact = idEmergencyContact;
    }*/

    public void setEmergencyContactPasien(EmergencyContactModel emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public EmergencyContactModel getEmergencyContactPasien() {
        return emergencyContact;
    }

    public void setListPasienPenyakitDiagnosis(List<PasienDiagnosisPenyakitModel> listPasienPenyakitDiagnosis) {
        this.listPasienPenyakitDiagnosis = listPasienPenyakitDiagnosis;
    }

    public List<PasienDiagnosisPenyakitModel> getListPasienPenyakitDiagnosis() {
        return listPasienPenyakitDiagnosis;
    }

    public void setListPasienAsuransi(List<PasienAsuransiModel> listPasienAsuransi) {
        this.listPasienAsuransi = listPasienAsuransi;
    }

    public List<PasienAsuransiModel> getListPasienAsuransi() {
        return listPasienAsuransi;
    }
}
