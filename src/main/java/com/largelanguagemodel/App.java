package com.largelanguagemodel;

import java.util.List;

import com.dao.database.DbConnection;
import com.dao.file.JsonUtility;
import com.dao.utils.ObjectUtility;
import com.largelanguagemodel.assets.Dico;
import com.largelanguagemodel.assets.Produit;
import com.largelanguagemodel.traitement.StringTreatment;
import com.largelanguagemodel.views.ProduitDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DbConnection dbConnection = new DbConnection();
        try{
            String recherche = "prix telephone superieure a 100";
            StringTreatment treat = new StringTreatment();
            String query = treat.getSearchQuery(recherche, dbConnection.getConnection());
            System.out.println(query);
            ProduitDetails produitDetails = new ProduitDetails();
            List<ProduitDetails> lst = produitDetails.executeQuery(dbConnection.getConnection(), query, produitDetails);
            for (ProduitDetails produitDetails2 : lst) {
                System.out.println(JsonUtility.encodeJson(produitDetails2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                dbConnection.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
