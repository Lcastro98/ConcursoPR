DROP TABLE IF EXISTS historial;
CREATE TABLE historial(
his_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
his_jugador varchar(20) NOT NULL,
his_fecha datetime NOT NULL,
his_acum int NOT NULL
);