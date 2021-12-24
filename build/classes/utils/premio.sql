DROP TABLE IF EXISTS premio;
CREATE TABLE premio(
premio_id int PRIMARY KEY,
premio_ronda_id int NOT NULL,
premio_punt int NOT NULL,
foreign key(premio_ronda_id) references ronda(ronda_id)
);

INSERT INTO premio values(1, 1, 4);
INSERT INTO premio values(2, 2, 12);
INSERT INTO premio values(3, 3, 20);
INSERT INTO premio values(4, 4, 28);
INSERT INTO premio values(5, 5, 36);
