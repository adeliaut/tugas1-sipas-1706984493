package apap.tugas1.sipas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="emergency_contact")
public class EmergencyContactModel implements Serializable {
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
    @Column(name = "nik", nullable = false)
    public String nik;

    @NotNull
    @Size(max = 255)
    @Column(name = "noHp", nullable = false)
    public String noHp;

    // Relationship Pasien - Emergency Contact
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idEmergencyContact", referencedColumnName ="id")
    public PasienModel emergencyContactPasien;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNamaEmergencyContact(String nama) {
        this.nama = nama;
    }

    public String getNamaEmergencyContact() {
        return nama;
    }

    public void setNIKEmergencyContact(String nik) {
        this.nik = nik;
    }

    public String getNIKEmergencyContact() {
        return nik;
    }

    public void setNoHpEmergencyContact(String noHp) {
        this.noHp = noHp;
    }

    public String getNoHpEmergencyContact() {
        return noHp;
    }

    public PasienModel getEmergencyContactPasien() {
        return emergencyContactPasien;
    }

    public void setEmergencyContactPasien(PasienModel emergencyContactPasien) {
        this.emergencyContactPasien = emergencyContactPasien;
    }
}