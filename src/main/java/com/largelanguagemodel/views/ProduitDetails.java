package com.largelanguagemodel.views;

import com.dao.annotation.Column;
import com.dao.annotation.Table;
import com.dao.database.BddObject;

@Table(name = "v_details_produit")
public class ProduitDetails extends BddObject{
    @Column(name = "id_produit")
    String idProduit;
    @Column
    String libelle;
    @Column
    String categorie;
    @Column
    Double prix;    
    @Column
    Integer qualite;
    @Column
    Double rapport;

    public String getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public Integer getQualite() {
        return qualite;
    }
    public void setQualite(Integer qualite) {
        this.qualite = qualite;
    }
    public Double getRapport() {
        return rapport;
    }
    public void setRapport(Double rapport) {
        this.rapport = rapport;
    }   
}
