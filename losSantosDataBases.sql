create schema LosSantosCustom;
use LosSantosCustom;

CREATE TABLE dealership(
id_dealership INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
address VARCHAR(200) NOT NULL,
phone_number CHAR(9) NOT NULL,
city VARCHAR(100) NOT NULL,
postcode CHAR(5) NOT NULL
);
 
CREATE TABLE client(
id_client INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
dni CHAR(9) UNIQUE NOT NULL,
phone_number CHAR(9) NOT NULL,
email VARCHAR(100) NOT NULL,
address VARCHAR(200) NOT NULL,
creation_date DATE DEFAULT now()
);

CREATE TABLE users(
id_user INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password CHAR(60) NOT NULL,
rol ENUM('VENTAS','MECANICO', 'JEFES') NOT NULL,
id_dealership INT NOT NULL,

FOREIGN KEY (id_dealership) REFERENCES dealership(id_dealership)
);

CREATE TABLE vehicles(
id_vehicle INT PRIMARY KEY AUTO_INCREMENT,
vehicle_type ENUM('MOTOCICLETA','COCHE','CICLOMOTORES') NOT NULL,
model VARCHAR(150) NOT NULL,
year  INT NOT NULL,
price DECIMAL(10,2) NOT NULL,
color VARCHAR(30) NOT NULL,
plate VARCHAR(9),			-- contando espacio entre numeros y letras
VIN VARCHAR(17) UNIQUE NOT NULL,
mileage INT NOT NULL DEFAULT 0,
fuel ENUM('GASOLINA', 'DIESEL','ELECTRICO')  NOT NULL,
status ENUM('DISPONIBLE', 'VENDIDO', 'REPARACION') NOT NULL DEFAULT 'DISPONIBLE',
resource_path LONGTEXT,
id_dealership INT NOT NULL,

FOREIGN KEY (id_dealership) REFERENCES delaership(id_dealership)
);

CREATE TABLE mechanics(
id_mechanic INT PRIMARY KEY AUTO_INCREMENT,
is_boss BOOLEAN NOT NULL DEFAULT FALSE,
specialization ENUM('MOTOCICLETAS', 'CICLOMOTORES', 'COCHES'),
id_user INT NOT NULL,

FOREIGN KEY (id_user) REFERENCES users(id_user)
);