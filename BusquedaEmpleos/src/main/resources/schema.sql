-- Script para crear la base de datos empleosdb (MySQL)


CREATE TABLE  Categorias (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  descripcion varchar(100)
); 


CREATE TABLE  Perfiles (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  perfil varchar(100) NOT NULL
); 


CREATE TABLE  Usuarios (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(45) NOT NULL,
  email varchar(100) NOT NULL,
  username varchar(45) NOT NULL,
  password varchar(100) NOT NULL,
  estatus int(11) NOT NULL DEFAULT '1',
  fechaRegistro date DEFAULT NULL,
  UNIQUE KEY username_UNIQUE (username),
  UNIQUE KEY email_UNIQUE (email)
); 


CREATE TABLE  Vacantes (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(200) NOT NULL,
  descripcion varchar(100) NOT NULL,
  fecha date NOT NULL,
  salario double NOT NULL,
  estatus enum('Creada','Aprobada','Eliminada') NOT NULL,
  destacado boolean NOT NULL,
  imagen varchar(250) NOT NULL,
  detalles varchar(100),
  idCategoria int(11) NOT NULL,
  CONSTRAINT fk_vacantes_categorias1 FOREIGN KEY (idCategoria) REFERENCES Categorias (id)
); 


CREATE TABLE  Solicitudes (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  fecha date NOT NULL,
  archivo varchar(250) NOT NULL,
  comentarios varchar(100),
  idVacante int(11) NOT NULL,
  idUsuario int(11) NOT NULL,
  UNIQUE KEY Vacante_Usuario_UNIQUE (idVacante,idUsuario),
  CONSTRAINT fk_Solicitudes_Usuarios1 FOREIGN KEY (idUsuario) REFERENCES Usuarios (id),
  CONSTRAINT fk_Solicitudes_Vacantes1 FOREIGN KEY (idVacante) REFERENCES Vacantes (id)
); 


CREATE TABLE  UsuarioPerfil (
  idUsuario int(11) NOT NULL,
  idPerfil int(11) NOT NULL,
  UNIQUE KEY Usuario_Perfil_UNIQUE (idUsuario,idPerfil),
  CONSTRAINT fk_Usuarios1 FOREIGN KEY (idUsuario) REFERENCES Usuarios (id),
  CONSTRAINT fk_Perfiles1 FOREIGN KEY (idPerfil) REFERENCES Perfiles (id)
); 

CREATE INDEX  fk_vacantes_categorias1_idx ON Vacantes(idCategoria);
CREATE INDEX  fk_Solicitudes_Vacantes1_idx ON Solicitudes(idVacante);
CREATE INDEX  fk_Solicitudes_Usuarios1_idx ON Solicitudes(idUsuario);
CREATE INDEX  fk_Usuarios1_idx ON UsuarioPerfil(idUsuario);
CREATE INDEX  fk_Perfiles1_idx ON UsuarioPerfil(idPerfil);

