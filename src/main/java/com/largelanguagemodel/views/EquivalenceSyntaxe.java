package com.largelanguagemodel.views;

import com.dao.annotation.Column;
import com.dao.annotation.Table;
import com.dao.database.BddObject;

@Table(name = "v_equivalence_syntaxe")
public class EquivalenceSyntaxe extends BddObject{
    @Column
    String nom;
    @Column
    String equivalence;
    @Column
    String libelle;
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEquivalence() {
        return equivalence;
    }
    public void setEquivalence(String equivalence) {
        this.equivalence = equivalence;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
