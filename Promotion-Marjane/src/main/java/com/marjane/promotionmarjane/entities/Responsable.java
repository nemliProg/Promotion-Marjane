package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

@Entity
@IdClass(ResponsablePK.class)
public class Responsable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_centre")
    private long idCentre;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cat")
    private long idCat;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_centre", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Centre centreByIdCentre;
    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Categorie categorieByIdCat;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Responsable that = (Responsable) o;

        if (idCentre != that.idCentre) return false;
        if (idCat != that.idCat) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCentre ^ (idCentre >>> 32));
        result = 31 * result + (int) (idCat ^ (idCat >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
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
