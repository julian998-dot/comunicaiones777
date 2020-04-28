create sequence SUS_TIPO_RECURSO_seq
  start with 1
  increment by 1
  maxvalue 99999999
  minvalue 1;

CREATE TABLE TIPO_RECURSO
(id integer NOT NULL DEFAULT NEXTVAL('SUS_TIPO_RECURSO_seq'),
tipo VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

create sequence SUS_RECURSO_seq
  start with 1
  increment by 1
  maxvalue 99999999
  minvalue 1;

CREATE TABLE RECURSO
(id_interno integer NOT NULL DEFAULT NEXTVAL('SUS_RECURSO_seq'),
id_tipo integer NOT NULL,
nombre VARCHAR(50) NOT NULL,
ubicacion VARCHAR(50) NOT NULL,
capacidad integer,
estado VARCHAR(50) NOT NULL,
PRIMARY KEY (id_interno),
CONSTRAINT fk_recurso_tipoRecurso
    FOREIGN KEY(id_tipo)
    REFERENCES TIPO_RECURSO(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

create sequence SUS_HORARIO_seq
  start with 1
  increment by 1
  maxvalue 99999999
  minvalue 1;

CREATE TABLE HORARIO
(id integer NOT NULL DEFAULT NEXTVAL('SUS_HORARIO_seq'),
id_recurso integer NOT NULL,
hora_inicio time NOT NULL,
hora_fin time NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_horario_recurso
    FOREIGN KEY(id_recurso)
    REFERENCES RECURSO(id_interno)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE USUARIO(
id VARCHAR(50) NOT NULL,
passw VARCHAR(100) NOT NULL,
tipo VARCHAR(50) NOT NULL,
carnet integer NOT NULL,
nombre VARCHAR(50) NOT NULL,
carrera VARCHAR (50) NOT NULL,
PRIMARY KEY(id)
);

CREATE SEQUENCE SUS_RESERVA_seq
  start with 1
  increment by 1
  maxvalue 99999999
  minvalue 1;

CREATE TABLE RESERVA
(id integer NOT NULL DEFAULT NEXTVAL('SUS_RESERVA_seq'),
fecha_ini TIMESTAMP NOT NULL,
fecha_fin TIMESTAMP NOT NULL,
id_recurso integer,
id_usuario VARCHAR(50),
estado VARCHAR(50) NOT NULL,
tipo VARCHAR(50) NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_reserva_usuario
    FOREIGN KEY(id_usuario)
    REFERENCES USUARIO(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT fk_reserva_recurso
    FOREIGN KEY(id_recurso)
    REFERENCES RECURSO(id_interno)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

insert into tipo_recurso(id,tipo) values(1,'Computador');
insert into tipo_recurso(id,tipo) values(2,'Multimedia');
insert into tipo_recurso(id,tipo) values(3,'Sala de estudio');

insert into usuario(id,passw,tipo,carnet,nombre,carrera) values('regular@cvds.com','123456','regular',123456,'prueba','Ingenieria de sistemas');

insert into recurso(id_tipo,nombre,ubicacion,capacidad,estado) values(1,'El insertado','Biblioteca G',50,'Disponible');

insert into horario(id_recurso,hora_inicio,hora_fin) values(1,'00:00:00','23:59:59');


  
