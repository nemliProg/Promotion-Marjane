package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produit", schema = "public", catalog = "marjane")
public class ProduitEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prix")
    private double prix;
    @Basic
    @Column(name = "intial_prix")
    private double intialPrix;
    @Basic
    @Column(name = "id_cat")
    private long idCat;
    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id", nullable = false)
    private CategorieEntity categorieByIdCat;

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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getIntialPrix() {
        return intialPrix;
    }

    public void setIntialPrix(double intialPrix) {
        this.intialPrix = intialPrix;
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

        ProduitEntity that = (ProduitEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (Double.compare(that.intialPrix, intialPrix) != 0) return false;
        if (idCat != that.idCat) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(intialPrix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (idCat ^ (idCat >>> 32));
        return result;
    }

    public CategorieEntity getCategorieByIdCat() {
        return categorieByIdCat;
    }

    public void setCategorieByIdCat(CategorieEntity categorieByIdCat) {
        this.categorieByIdCat = categorieByIdCat;
    }
}
