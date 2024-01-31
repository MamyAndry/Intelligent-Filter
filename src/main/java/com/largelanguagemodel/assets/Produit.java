package com.largelanguagemodel.assets;

import com.dao.annotation.Column;
import com.dao.annotation.ForeignKey;
import com.dao.annotation.PrimaryKey;
import com.dao.annotation.Table;
import com.dao.annotation.conf.ForeignType;
import com.dao.database.BddObject;

@Table
public class Produit extends BddObject{
    @PrimaryKey(prefix = "PRD", sequence = "seq_produit", length = 8)
    @Column(name = "id_produit")
    private String idProduit;
    @Column
    private String libelle;
    @ForeignKey(mappedBy = "id_categorie", foreignType = ForeignType.OneToMany)
    private Categorie categorie;
    @Column
    private Double prix;    
    @Column
    private Integer qualite;

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
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
}
