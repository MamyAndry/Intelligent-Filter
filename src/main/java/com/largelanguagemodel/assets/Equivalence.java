package com.largelanguagemodel.assets;

import com.dao.annotation.Column;
import com.dao.annotation.ForeignKey;
import com.dao.annotation.PrimaryKey;
import com.dao.annotation.conf.ForeignType;
import com.dao.database.BddObject;

public class Equivalence extends BddObject {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id_equivalence")
    String idEquivalence;
    @ForeignKey(mappedBy = "id_syntaxe", foreignType = ForeignType.OneToMany)
    Syntaxe syntaxe;
    @ForeignKey(mappedBy = "id_column", foreignType = ForeignType.OneToMany)
    Columns column;
    @Column
    String equivalence;

    public String getIdEquivalence() {
        return idEquivalence;
    }
    public void setIdEquivalence(String idEquivalence) {
        this.idEquivalence = idEquivalence;
    }
    public Syntaxe getSyntaxe() {
        return syntaxe;
    }
    public void setSyntaxe(Syntaxe syntaxe) {
        this.syntaxe = syntaxe;
    }
    public Columns getColumn() {
        return column;
    }
    public void setColumn(Columns column) {
        this.column = column;
    }
    public String getEquivalence() {
        return equivalence;
    }
    public void setEquivalence(String equivalence) {
        this.equivalence = equivalence;
    }
    
    
}
