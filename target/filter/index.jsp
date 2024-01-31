<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@page import="com.largelanguagemodel.views.ProduitDetails, com.dao.database.DbConnection, java.util.List, com.largelanguagemodel.traitement.StringTreatment" %>
<% 
    DbConnection dbConnection = new DbConnection();
    try{
        ProduitDetails produitDetails = new ProduitDetails();
        List<ProduitDetails> lst = null;
        if(request.getParameter("query") != null){
            String recherche = (String) request.getParameter("query");
            StringTreatment treat = new StringTreatment();
            String query = treat.getSearchQuery(recherche, dbConnection.getConnection());
            lst = produitDetails.executeQuery(dbConnection.getConnection(), query, produitDetails);
        }else{
            lst = produitDetails.findAll(dbConnection.getConnection());
        }
%>
<html>
    <head>
        <title>Produit</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="" name="description">
        <meta content="" name="keywords">
      
        <!-- Favicons -->
        <link href="icon/ventes.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
            
        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
      
        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
      
        <!-- =======================================================
        * Template Name: NiceAdmin
        * Updated: Jul 27 2023 with Bootstrap v5.3.1
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>
    <body>

    <%@include file="template/header.html" %>
    <main id="main" class="main">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Liste produit</h5>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Libelle</th>
                                        <th scope="col">Categorie</th>
                                        <th scope="col">Prix</th>
                                        <th scope="col">Qualite</th>
                                        <th scope="col">Rapport</th>
                                    <tr>
                                </thead>
                                <tbody>
                                    <% for (ProduitDetails produitDetails2 : lst)  { %>
                                    <tr>
                                        <td><%=produitDetails2.getIdProduit()%></td>
                                        <td><%=produitDetails2.getLibelle()%></td>
                                        <td><%=produitDetails2.getCategorie()%></td>
                                        <td><%=produitDetails2.getPrix()%></td>
                                        <td><%=produitDetails2.getQualite()%></td>
                                        <td><%=produitDetails2.getRapport()%></td>
                                    </tr>   
                                    <% } %>
                                </tbody>
                                <%
                                    } catch (Exception e) {
                                        e.printStackTrace(new java.io.PrintWriter(out));
                                    }finally{
                                        try {
                                            dbConnection.close();
                                        } catch (Exception e) {
                                            e.printStackTrace(new java.io.PrintWriter(out));
                                        }
                                    }
                                %>
                            </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    </body>

    <%@include file="template/footer.html" %>
</html>
