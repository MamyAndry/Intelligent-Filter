INSERT INTO categorie VALUES
    ('CAT0001', 'Telephone'),
    ('CAT0002', 'Automobile'),
    ('CAT0003', 'Textile'),
    ('CAT0004', 'Accessoire');

INSERT INTO produit VALUES
    ('PRD0001','Samsung S23', 'CAT0001', 180, 8),
    ('PRD0002','Iphone 15', 'CAT0001', 200, 9),
    ('PRD0003','Porsche 911', 'CAT0002', 1000, 8),
    ('PRD0004','Mustang 2015', 'CAT0002', 500, 5);

INSERT INTO syntaxe VALUES
    ('SYN0001', 'meilleur'),
    ('SYN0002', 'pire'),
    ('SYN0003', 'inferieur'),
    ('SYN0004', 'superieur'),
    ('SYN0005', 'plus'),
    ('SYN0006', 'moins');

INSERT INTO columns VALUES
    ('COL0001', 'prix'),
    ('COL0002', 'qualite'),
    ('COL0003', 'rapport');

INSERT INTO equivalence VALUES
    (default, 'SYN0001', 'COL0001', 'ORDER BY prix ASC'),
    (default, 'SYN0001', 'COL0002', 'ORDER BY qualite DESC'),
    (default, 'SYN0001', 'COL0003', 'ORDER BY rapport DESC'),
    (default, 'SYN0002', 'COL0001', 'ORDER BY prix DESC'),
    (default, 'SYN0002', 'COL0002', 'ORDER BY qualite ASC'),
    (default, 'SYN0002', 'COL0003', 'ORDER BY rapport ASC'),
    (default, 'SYN0003', 'COL0001', ' < '),
    (default, 'SYN0003', 'COL0002', ' < '),
    (default, 'SYN0003', 'COL0003', ' < '),
    (default, 'SYN0004', 'COL0001', ' > '),
    (default, 'SYN0004', 'COL0002', ' > '),
    (default, 'SYN0004', 'COL0003', ' > '),
    (default, 'SYN0005', 'COL0001', 'AND prix = (SELECT MAX(prix) FROM v_details_produit WHERE categorie LIKE ?)'),
    (default, 'SYN0005', 'COL0002', 'AND qualite = (SELECT MAX(qualite) FROM v_details_produit WHERE categorie LIKE ?)'),
    (default, 'SYN0005', 'COL0003', 'AND rapport = (SELECT MAX(rapport) FROM v_details_produit WHERE categorie LIKE ?)'),
    (default, 'SYN0006', 'COL0001', 'AND prix = (SELECT MIN(prix) FROM v_details_produit WHERE categorie LIKE ?)'),
    (default, 'SYN0006', 'COL0002', 'AND qualite = (SELECT MIN(qualite) FROM v_details_produit WHERE categorie LIKE ?)'),
    (default, 'SYN0006', 'COL0003', 'AND rapport = (SELECT MIN(rapport) FROM v_details_produit WHERE categorie LIKE ?)');

INSERT INTO dico VALUES
    (default, 'COL0001', 'prix'),
    (default, 'COL0001', 'chere'),
    (default, 'COL0001', 'cher'),
    (default, 'COL0001', 'couteux');