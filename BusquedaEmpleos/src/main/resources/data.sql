insert into Categorias values
(1,'Ventas','Area de dedicada a vender productos'),
(2,'Sistemas','Dedicada al area de programacion'),
(3,'Seguridad','dedicada a la seguridad de la empresa'),
(4,'Contabilidad','llevar los registros contables'),
(5,'Limpieza','Realizar la limpieza de la empresa');

insert into VACANTES values 
(1,'Para realizar contabilidad de la empresa','auxiliar contable','2020-12-03',1678.98,'Creada',true,'scotia.ico','detalles',4),
(2,'Para realizar limpieza de la empresa','Encargado de limpieza','1990-01-28',1453.23,'Aprobada',false,'ViveIndice.png','detalles',5),
(3,'Para realizar programacion de la empresa','Ingeniero en sistemas','2020-04-15',2200.00,'Eliminada',false,'inbursa.jpeg','detalles',2);

insert into Perfiles values
(1,'Supervisor'),
(2,'Administrador'),
(3,'Usuario');

insert into Usuarios values
(1,'Joel', 'correo@yahoo.com.mx','cachondo26','passwor',1,'2000-08-04'),
(2,'Manuel', 'correo1@yahoo.com.mx','Manu22','passwor',2,'2000-12-28'),
(3,'Maria', 'correo2@yahoo.com.mx','Mary77','passwor',3,'2000-07-03');

insert into UsuarioPerfil values
(1,1),
(1,2),
(2,3),
(2,1),
(3,3);
