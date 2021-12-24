DROP TABLE IF EXISTS his_detalle;
CREATE TABLE his_detalle(
his_id int NOT NULL,
his_premio_id int NOT NULL,
foreign key(his_id) references historial(his_id),
foreign key(his_premio_id) references premio(premio_id)
);