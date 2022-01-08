use supermercados;

CREATE TABLE Articulo(
	id       int not null,
	nombre   varchar(50) not null,
	unidadesStock 		int not null,
	precio 		double not null,
	
	PRIMARY KEY (id)
);

CREATE TABLE Usuario (
	nombre   varchar(70) not null,
	dni   varchar(9) not null,
	direccion   varchar(100) not null,
	email   varchar(50) not null,
	comprasMensuales	int not null,
    
    PRIMARY KEY (dni)
);

DROP TABLE Usuario;

INSERT INTO Usuario VALUES ("Juan", "12345678j", "j", "j@gmail.com", 0);
INSERT INTO Usuario VALUES ("Pepe", "12345671a", "a", "a@gmail.com", 0);
INSERT INTO Usuario VALUES ("Pepa", "12345678a", "pepa", "pepa@gmail.com", 0);
INSERT INTO Usuario VALUES ("Juana", "12345672b", "b", "b@gmail.com", 0);

INSERT INTO Articulo VALUES (1, "Leche", 80, 1.0);
INSERT INTO Articulo VALUES (2, "Pan", 30, 0.5);
INSERT INTO Articulo VALUES (3, "Huevos", 50, 1.5);
INSERT INTO Articulo VALUES (4, "Chocolate", 25, 1.0);