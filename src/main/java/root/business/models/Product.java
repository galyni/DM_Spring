package business.models;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity // il s’agit d’une classe à persister
@Table(name = "product")
public class Product {

    private String nom;
    @Basic(optional = false)
    private String code;
    @Basic(optional = false)
    private int quantite;
    @Basic(optional = false)
    private LocalDate datePeremption;

    @Basic(optional = false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic(optional = false)
    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic(optional = false)
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Basic(optional = false)
    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }
}
