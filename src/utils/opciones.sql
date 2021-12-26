DROP TABLE IF EXISTS opciones;
CREATE TABLE opciones(
op_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
op_pre_id int NOT NULL,
op_text varchar(255) NOT NULL,
op_correct boolean NOT NULL,
foreign key(op_pre_id) references pregunta(pre_id)
);