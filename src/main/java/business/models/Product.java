package business.models;

import java.time.LocalDate;

public class Product {
    private String Nom;
    private String Code;
    private int Quantite;
    private LocalDate DatePeremption;

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }

    public LocalDate getDatePeremption() {
        return DatePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        DatePeremption = datePeremption;
    }
}
