package apap.tugas1.sipas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="pasien_asuransi")
public class PasienAsuransiModel implements Serializable{
    @Id
    @Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // Relationship Pasien - Asuransi
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPasien", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public PasienModel pasienAsuransi;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idAsuransi", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public AsuransiModel asuransi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PasienModel getPasienAsuransi() {
        return pasienAsuransi;
    }

    public void setPasienAsuransi(PasienModel pasienAsuransi) {
        this.pasienAsuransi = pasienAsuransi;
    }

    public AsuransiModel getAsuransi() {
        return asuransi;
    }

    public void setAsuransi(AsuransiModel asuransi) {
        this.asuransi = asuransi;
    }
}
