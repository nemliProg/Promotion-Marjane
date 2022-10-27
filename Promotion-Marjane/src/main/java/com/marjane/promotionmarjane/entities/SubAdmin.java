package com.marjane.promotionmarjane.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_admin", schema = "public", catalog = "marjane")
public class SubAdmin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
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
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Centre centreById;

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

        SubAdmin subAdmin = (SubAdmin) o;

        if (id != subAdmin.id) return false;
        if (nom != null ? !nom.equals(subAdmin.nom) : subAdmin.nom != null) return false;
        if (prenom != null ? !prenom.equals(subAdmin.prenom) : subAdmin.prenom != null) return false;
        if (email != null ? !email.equals(subAdmin.email) : subAdmin.email != null) return false;
        if (password != null ? !password.equals(subAdmin.password) : subAdmin.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Centre getCentreById() {
        return centreById;
    }

    public void setCentreById(Centre centreById) {
        this.centreById = centreById;
    }
}
