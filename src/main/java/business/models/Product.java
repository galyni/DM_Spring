package business.models;

import org.springframework.stereotype.Component;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Product")
public class Product
{
    private Integer   id ;
    private String    Nom ;
    private String    Code ;
    private int       Quantite ;
    private Date      DatePeremption ;

    public Product(){}

    @Id
    public Integer getId(){return id;}
    @Basic(optional = false)
    public String getNom() {return this.Nom;}

    public void setNom(String nom) {this.Nom = nom;}
    @Basic(optional = false)
    public String getCode() {return this.Code;}

    public void setCode(String code) {this.Code = code;}
    @Basic(optional = false)
    public int getQuantite() {return this.Quantite;}

    public void setQuantite(int quantite) {Quantite = quantite;}
    @Basic(optional = false)
    public Date getDatePeremption() {return this.DatePeremption;}

    public void setDatePeremption(Date datePeremption) {this.DatePeremption = datePeremption;}
}
