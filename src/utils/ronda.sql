DROP TABLE IF EXISTS ronda;
CREATE TABLE ronda(
ronda_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
ronda_cat_id int NOT NULL UNIQUE,
ronda_nom varchar(20) NOT NULL, 
foreign key(ronda_cat_id) references categoria(cat_id)
);

INSERT INTO ronda values(0, 1, "Primera Ronda");
INSERT INTO ronda values(0, 2, "Segunda Ronda");
INSERT INTO ronda values(0, 3, "Tercera Ronda");
INSERT INTO ronda values(0, 4, "Cuarta Ronda");
INSERT INTO ronda values(0, 5, "Quinta Ronda");