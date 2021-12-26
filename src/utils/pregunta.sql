DROP TABLE IF EXISTS pregunta;
CREATE TABLE pregunta(
pre_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
pre_cat_id int NOT NULL,
pre_enun varchar(255) NOT NULL,
foreign key(pre_cat_id) references categoria(cat_id)
);