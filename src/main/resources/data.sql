CREATE TABLE  doctor (id integer not null, apellido varchar(255),
especialidad integer, nombres varchar(255), primary key (id));

CREATE TABLE citacion (id integer not null, hora_cita timestamp,
notificacion_pdf boolean, observacion varchar(255), urgente boolean,
doctor integer, primary key (id));

ALTER TABLE citacion add constraint citacion_doctor foreign key (doctor) references doctor;

INSERT INTO DOCTOR VALUES(1, 'PRUEBA1', 102, 'PRUEBA1');
INSERT INTO DOCTOR VALUES(2, 'PRUEBA2', 103, 'PRUEBA2');
INSERT INTO DOCTOR VALUES(3, 'PRUEBA3', 104, 'PRUEBA3');

INSERT INTO CITACION VALUES(1, '2023-03-09' , 1, 'CONSULTA1', 0, 2);
INSERT INTO CITACION VALUES(2, '2023-03-10' , 0, 'CONSULTA2', 1, 3);
