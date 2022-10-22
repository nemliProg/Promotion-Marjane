package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "id_cat")
    private long idCat;
    @Basic
    @Column(name = "id_centre")
    private long idCentre;
    @Basic
    @Column(name = "pourcentage")
    private BigDecimal pourcentage;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id", nullable = false)
    private Categorie categorieByIdCat;
    @ManyToOne
    @JoinColumn(name = "id_centre", referencedColumnName = "id", nullable = false)
    private Centre centreByIdCentre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    public long getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(long idCentre) {
        this.idCentre = idCentre;
    }

    public BigDecimal getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (idCat != promotion.idCat) return false;
        if (idCentre != promotion.idCentre) return false;
        if (pourcentage != null ? !pourcentage.equals(promotion.pourcentage) : promotion.pourcentage != null)
            return false;
        if (description != null ? !description.equals(promotion.description) : promotion.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCat ^ (idCat >>> 32));
        result = 31 * result + (int) (idCentre ^ (idCentre >>> 32));
        result = 31 * result + (pourcentage != null ? pourcentage.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Categorie getCategorieByIdCat() {
        return categorieByIdCat;
    }

    public void setCategorieByIdCat(Categorie categorieByIdCat) {
        this.categorieByIdCat = categorieByIdCat;
    }

    public Centre getCentreByIdCentre() {
        return centreByIdCentre;
    }

    public void setCentreByIdCentre(Centre centreByIdCentre) {
        this.centreByIdCentre = centreByIdCentre;
    }
}
