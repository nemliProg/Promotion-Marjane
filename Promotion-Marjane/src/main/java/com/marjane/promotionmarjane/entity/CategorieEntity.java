package com.marjane.promotionmarjane.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "categorie", schema = "public", catalog = "marjane")
public class CategorieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "categorieByIdCat")
    private Collection<ProduitEntity> produitsById;

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

        CategorieEntity that = (CategorieEntity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    public Collection<ProduitEntity> getProduitsById() {
        return produitsById;
    }

    public void setProduitsById(Collection<ProduitEntity> produitsById) {
        this.produitsById = produitsById;
    }
}
