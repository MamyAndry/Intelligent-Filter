package com.largelanguagemodel.traitement;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import com.dao.utils.ObjectUtility;
import com.largelanguagemodel.assets.Categorie;
import com.largelanguagemodel.assets.Columns;
import com.largelanguagemodel.assets.Dico;
import com.largelanguagemodel.assets.Syntaxe;
import com.largelanguagemodel.views.EquivalenceSyntaxe;

public class StringTreatment {
    String query = "SELECT * FROM v_details_produit WHERE categorie LIKE '%#categorie#%' ";

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String[] treatNumber(String nbr){
        return nbr.split(",");
    }
    public HashMap<String, String> analyze(String str, Connection con) throws Exception{
        HashMap<String, String> lst = new HashMap<>();
        String[] splited = str.split(" ");

        List<String> lstColumns = new Columns().getListNom(con);
        List<String> lstSyntaxes = new Syntaxe().getListLibelle(con);
        List<String> lstCategories = new Categorie().getListNom(con);
        String temp = ""; 
        for (int i = 0; i < splited.length; i++) {
            temp = splited[i].toLowerCase();
            temp = new Dico().getRoot(temp, con);
            if(lstColumns.contains(temp)){
                lst.put("column", temp);
            }else if(lstSyntaxes.contains(temp)){
                lst.put("syntaxe", temp);
            }else if(lstCategories.contains(temp)){
                lst.put("categorie", temp);
            }else if(ObjectUtility.isStringNumeric(temp)){
                lst.put("number", temp);
            }
        }
        return lst;
   }  

   public String getSearchQuery(String str, Connection con) throws Exception{
        String res = this.getQuery();
        HashMap<String, String> map = this.analyze(str, con);
        String categorie = "";
        String condition = "";
        if(map.get("categorie") != null){
            categorie = map.get("categorie");
        }
        if(map.get("syntaxe") != null && map.get("column") != null && map.get("number") == null){
            List<EquivalenceSyntaxe> equivalenceSyntaxe = new EquivalenceSyntaxe().findWhere(
                con, "nom = '" + map.get("column") + "' AND libelle = '" + map.get("syntaxe") + "'");
            String temp = "'%" + categorie +"%'";
            condition +=  equivalenceSyntaxe.get(0).getEquivalence().replace("?", temp);
        } 
        if(map.get("syntaxe") != null && map.get("column") != null && map.get("number") != null){
            condition += "AND ";
            String[] numbers = this.treatNumber(map.get("number"));
            List<EquivalenceSyntaxe> equivalenceSyntaxe = new EquivalenceSyntaxe().findWhere(
                con, "nom = '" + map.get("column") + "' AND libelle = '" + map.get("syntaxe") + "'");
            condition += equivalenceSyntaxe.get(0).getEquivalence()
                .replace("?1", numbers[0]);
            if(numbers.length == 2)
               condition = condition.replace("?2", numbers[1]);
        }

        res = res.replace("#categorie#", categorie);
        res += condition;
        return res;
   }
   
}
