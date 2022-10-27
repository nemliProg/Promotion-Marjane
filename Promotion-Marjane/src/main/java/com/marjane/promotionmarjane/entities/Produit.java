package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prix")
    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id", nullable = false)
    private Categorie categorieByIdCat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (id != produit.id) return false;
        if (nom != null ? !nom.equals(produit.nom) : produit.nom != null) return false;
        if (prix != null ? !prix.equals(produit.prix) : produit.prix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        return result;
    }

    public Categorie getCategorieByIdCat() {
        return categorieByIdCat;
    }

    public void setCategorieByIdCat(Categorie categorieByIdCat) {
        this.categorieByIdCat = categorieByIdCat;
    }
}
