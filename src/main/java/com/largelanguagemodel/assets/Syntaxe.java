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
public class Syntaxe extends BddObject {
    @PrimaryKey(sequence = "seq_syntaxe", prefix = "OP", length = 7)
    @Column(name = "id_syntaxe")
    String idSyntaxe;
    @Column
    String libelle;
    public String getIdSyntaxe() {
        return idSyntaxe;
    }
    public void setIdSyntaxe(String idSyntaxe) {
        this.idSyntaxe = idSyntaxe;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public List<String> getListLibelle(Connection con) throws Exception{
        ArrayList<String> lst = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("SELECT libelle FROM syntaxe");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            lst.add(rs.getString(1));
        }
        return lst;
    }
    
}
