Create database proyecto1;
use proyecto1;

CREATE TABLE Vehiculo (
id_vehiculo int auto_increment,
tipo varchar(250) not null,
marca varchar(250) not null,
potencia int not null,
fecha_compra datetime not null,
primary key (id_vehiculo
));