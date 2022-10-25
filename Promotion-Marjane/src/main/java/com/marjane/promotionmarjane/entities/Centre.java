package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Centre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "ville")
    private String ville;
    @Basic
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "centreByIdCentre")
    private Collection<Promotion> promotionsById;
    @OneToMany(mappedBy = "centreByIdCentre")
    private Collection<Responsable> responsablesById;
    @OneToOne(mappedBy = "centreById")
    private SubAdmin subAdminById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Centre{" +
                "id=" + id +
                ", ville='" + ville + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Centre centre = (Centre) o;

        if (id != centre.id) return false;
        if (ville != null ? !ville.equals(centre.ville) : centre.ville != null) return false;
        if (nom != null ? !nom.equals(centre.nom) : centre.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
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

    public SubAdmin getSubAdminById() {
        return subAdminById;
    }

    public void setSubAdminById(SubAdmin subAdminById) {
        this.subAdminById = subAdminById;
    }
}
