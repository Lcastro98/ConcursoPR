DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria(
cat_id int PRIMARY KEY,
cat_nom varchar(20) NOT NULL
);

INSERT INTO categoria values(1, "Nivel 1");
INSERT INTO categoria values(2, "Nivel 2");
INSERT INTO categoria values(3, "Nivel 3");
INSERT INTO categoria values(4, "Nivel 4");
INSERT INTO categoria values(5, "Nivel 5");