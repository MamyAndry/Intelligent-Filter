package com.largelanguagemodel.assets;

import java.sql.Connection;
import java.util.List;

import com.dao.annotation.Column;
import com.dao.annotation.ForeignKey;
import com.dao.annotation.PrimaryKey;
import com.dao.annotation.conf.ForeignType;
import com.dao.database.BddObject;

public class Dico extends BddObject{
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id_dico")
    Integer idDico;
    @ForeignKey(mappedBy = "id_column", foreignType = ForeignType.OneToMany)
    Columns column;
    @Column
    String annexe;
    public Integer getIdDico() {
        return idDico;
    }
    public void setIdDico(Integer idDico) {
        this.idDico = idDico;
    }
    public Columns getColumn() {
        return column;
    }
    public void setColumn(Columns column) {
        this.column = column;
    }
    public String getAnnexe() {
        return annexe;
    }
    public void setAnnexe(String annexe) {
        this.annexe = annexe;
    }
    
    public String getRoot(String str, Connection con) throws Exception{
        List<Dico> lst = new Dico().findWhere(con, "annexe LIKE '"+str+"'");
        if(lst.size() == 0)
            return str;
        else{
            return lst.get(0).getColumn().getNom();
        }
    }
}
