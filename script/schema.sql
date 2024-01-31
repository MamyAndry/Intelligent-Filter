CREATE SEQUENCE seq_produit START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE seq_categorie START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE seq_operation START WITH 1
    INCREMENT BY 1;

CREATE TABLE categorie(
    id_categorie VARCHAR(8) PRIMARY KEY,
    nom VARCHAR(50)
);

CREATE TABLE produit(
    id_produit VARCHAR(8) PRIMARY KEY,
    libelle VARCHAR(50),
    id_categorie VARCHAR(50) REFERENCES categorie(id_categorie),
    prix DOUBLE PRECISION,
    qualite INTEGER
);

CREATE TABLE columns(
    id_column VARCHAR(8) PRIMARY KEY,
    nom VARCHAR(50)
);

CREATE TABLE syntaxe(
    id_syntaxe VARCHAR(8) PRIMARY KEY,
    libelle VARCHAR(50)
);

CREATE TABLE equivalence(
    id_equivalence SERIAL PRIMARY KEY,
    id_syntaxe VARCHAR(8) REFERENCES syntaxe(id_syntaxe),
    id_column VARCHAR(8) REFERENCES columns(id_column),
    equivalence VARCHAR(100)
);

CREATE TABLE dico(
    id_dico SERIAL PRIMARY KEY,
    id_column VARCHAR(8) REFERENCES columns(id_column),
    annexe VARCHAR(50) 
);

