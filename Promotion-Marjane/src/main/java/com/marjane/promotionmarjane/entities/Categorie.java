package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "categorieByIdCat")
    private Collection<Produit> produitsById;
    @OneToMany(mappedBy = "categorieByIdCat")
    private Collection<Promotion> promotionsById;
    @OneToMany(mappedBy = "categorieByIdCat")
    private Collection<Responsable> responsablesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (id != categorie.id) return false;
        if (nom != null ? !nom.equals(categorie.nom) : categorie.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    public Collection<Produit> getProduitsById() {
        return produitsById;
    }

    public void setProduitsById(Collection<Produit> produitsById) {
        this.produitsById = produitsById;
    }

    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    public Collection<Responsable> getResponsablesById() {
        return responsablesById;
    }

    public void setResponsablesById(Collection<Responsable> responsablesById) {
        this.responsablesById = responsablesById;
    }
}
