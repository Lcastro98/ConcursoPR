DROP TABLE IF EXISTS premio;
CREATE TABLE premio(
premio_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
premio_ronda_id int NOT NULL,
premio_punt int NOT NULL,
foreign key(premio_ronda_id) references ronda(ronda_id)
);

INSERT INTO premio values(0, 1, 4);
INSERT INTO premio values(0, 2, 12);
INSERT INTO premio values(0, 3, 20);
INSERT INTO premio values(0, 4, 28);
INSERT INTO premio values(0, 5, 36);
