CREATE OR REPLACE VIEW v_details_produit AS
    SELECT p.id_produit, p.libelle, c.nom categorie, p.prix, p.qualite, p.qualite/p.prix rapport FROM produit p 
        JOIN categorie c 
            ON p.id_categorie = c.id_categorie;

CREATE OR REPLACE VIEW v_equivalence_syntaxe AS
    SELECT col.nom, equ.equivalence, syn.libelle FROM columns col
        JOIN equivalence equ
            ON col.id_column = equ.id_column
        JOIN syntaxe syn
            ON syn.id_syntaxe = equ.id_syntaxe;