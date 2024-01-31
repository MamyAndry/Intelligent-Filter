package com.largelanguagemodel.assets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.annotation.Column;
import com.dao.annotation.PrimaryKey;
import com.dao.database.BddObject;

public class Columns extends BddObject {
    @PrimaryKey(sequence = "seq_column", prefix = "COL", length = 7)
    @Column(name = "id_column")
    String idColumn;
    @Column
    String nom;
    public String getIdColumn() {
        return idColumn;
    }
    public void setIdColumn(String idColumn) {
        this.idColumn = idColumn;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<String> getListNom(Connection con) throws Exception{
        ArrayList<String> lst = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("SELECT nom FROM columns");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            lst.add(rs.getString(1));
        }
        return lst;
    }
}
