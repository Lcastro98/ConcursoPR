DROP TABLE IF EXISTS ronda;
CREATE TABLE ronda(
ronda_id int PRIMARY KEY,
ronda_cat_id int NOT NULL UNIQUE,
ronda_nom varchar(20) NOT NULL, 
foreign key(ronda_cat_id) references categoria(cat_id)
);

INSERT INTO ronda values(1, 1, "Primera Ronda");
INSERT INTO ronda values(2, 2, "Segunda Ronda");
INSERT INTO ronda values(3, 3, "Tercera Ronda");
INSERT INTO ronda values(4, 4, "Cuarta Ronda");
INSERT INTO ronda values(5, 5, "Quinta Ronda");