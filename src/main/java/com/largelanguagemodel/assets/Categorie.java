package com.largelanguagemodel.assets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.annotation.Column;
import com.dao.annotation.PrimaryKey;
import com.dao.annotation.Table;
import com.dao.database.BddObject;

@Table
public class Categorie extends BddObject{
    @PrimaryKey(prefix = "CAT", sequence = "seq_categorie", length = 8)
    @Column(name = "id_categorie")
    private String idCategorir;
    @Column
    private String nom;
    
    public String getIdCategorir() {
        return idCategorir;
    }
    public void setIdCategorir(String idCategorir) {
        this.idCategorir = idCategorir;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<String> getListNom(Connection con) throws Exception{
        ArrayList<String> lst = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("SELECT nom FROM categorie");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            lst.add(rs.getString(1));
        }
        return lst;
    }
}
