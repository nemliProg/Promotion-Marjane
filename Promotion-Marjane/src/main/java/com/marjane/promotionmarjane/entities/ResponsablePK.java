package com.marjane.promotionmarjane.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ResponsablePK implements Serializable {
    @Column(name = "id_centre")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCentre;
    @Column(name = "id_cat")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCat;

    public long getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(long idCentre) {
        this.idCentre = idCentre;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponsablePK that = (ResponsablePK) o;

        if (idCentre != that.idCentre) return false;
        if (idCat != that.idCat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCentre ^ (idCentre >>> 32));
        result = 31 * result + (int) (idCat ^ (idCat >>> 32));
        return result;
    }
}
