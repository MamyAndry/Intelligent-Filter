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
    @Column
    String radical;
    @Column
    String annexe;

    public String getRadical() {
        return radical;
    }
    public void setRadical(String radical) {
        this.radical = radical;
    }
    public Integer getIdDico() {
        return idDico;
    }
    public void setIdDico(Integer idDico) {
        this.idDico = idDico;
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
            return lst.get(0).getRadical();
        }
    }
}
