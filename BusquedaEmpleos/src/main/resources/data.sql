insert into Categorias values
(1,'Ventas','Area de dedicada a vender productos'),
(2,'Sistemas','Dedicada al area de programacion'),
(3,'Seguridad','dedicada a la seguridad de la empresa'),
(4,'Contabilidad','llevar los registros contables'),
(5,'Limpieza','Realizar la limpieza de la empresa');

insert into VACANTES values 
(1,'auxiliar contable','Para realizar contabilidad de la empresa','2020-01-03',1678.98,'Creada',true,'scotia.ico','detalles',4),
(2,'Encargado de limpieza','Para realizar limpieza de la empresa','2020-03-04',1453.23,'Aprobada',true,'ViveIndice.png','detalles',5),
(3,'Ingeniero en sistemas','Para realizar programacion de la empresa','2015-04-15',2200.00,'Eliminada',false,'inbursa.jpeg','detalles',2);

insert into Perfiles values
(1,'Supervisor'),
(2,'Administrador'),
(3,'Usuario');

insert into Usuarios values
(1,'Joel', 'correo@yahoo.com.mx','cachondo26','{noop}p',1,'2000-08-04'),
(2,'Manuel', 'correo1@yahoo.com.mx','Manu22','{noop}p',2,'2000-12-28'),
(3,'Maria', 'correo2@yahoo.com.mx','mary','{noop}p',3,'2000-07-03');

insert into UsuarioPerfil values
(1,1),
(1,2),
(2,3),
(2,1),
(3,3);

-- noop indica que se lee un campo no encriptado
-- Insertamos nuestros usuarios
INSERT INTO users VALUES ('luis','{noop}luis123',1);
INSERT INTO users VALUES ('marisol','{noop}mari123',1);

-- Insertamos (asignamos roles) a nuestros usuarios.
INSERT INTO authorities VALUES ('luis','SUPERVISOR');
INSERT INTO authorities VALUES ('marisol','ADMINISTRADOR');