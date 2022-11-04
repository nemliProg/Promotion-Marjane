package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "pourcentage")
    private BigDecimal pourcentage;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "explanation")
    private String explanation;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "promostartdate",nullable = false)
    private Date promoStartDate;
    @Basic
    @Column(name = "promoenddate",nullable = false)
    private Date promoEndDate;

    @ManyToOne
    @JoinColumn(name = "id_centre", referencedColumnName = "id", nullable = false)
    private Centre centreByIdCentre;

    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id", nullable = false)
    private Categorie categorieByIdCat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPromoStartDate() {
        return promoStartDate;
    }

    public void setPromoStartDate(Date promoStartDate) {
        this.promoStartDate = promoStartDate;
    }

    public Date getPromoEndDate() {
        return promoEndDate;
    }

    public void setPromoEndDate(Date promoEndDate) {
        this.promoEndDate = promoEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (pourcentage != null ? !pourcentage.equals(promotion.pourcentage) : promotion.pourcentage != null)
            return false;
        if (description != null ? !description.equals(promotion.description) : promotion.description != null)
            return false;
        if (explanation != null ? !explanation.equals(promotion.explanation) : promotion.explanation != null)
            return false;
        if (status != null ? !status.equals(promotion.status) : promotion.status != null) return false;
        if (promoStartDate != null ? !promoStartDate.equals(promotion.promoStartDate) : promotion.promoStartDate != null)
            return false;
        if (promoEndDate != null ? !promoEndDate.equals(promotion.promoEndDate) : promotion.promoEndDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (pourcentage != null ? pourcentage.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (explanation != null ? explanation.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (promoStartDate != null ? promoStartDate.hashCode() : 0);
        result = 31 * result + (promoEndDate != null ? promoEndDate.hashCode() : 0);
        return result;
    }

    public Centre getCentreByIdCentre() {
        return centreByIdCentre;
    }

    public void setCentreByIdCentre(Centre centreByIdCentre) {
        this.centreByIdCentre = centreByIdCentre;
    }

    public Categorie getCategorieByIdCat() {
        return categorieByIdCat;
    }

    public void setCategorieByIdCat(Categorie categorieByIdCat) {
        this.categorieByIdCat = categorieByIdCat;
    }
}
