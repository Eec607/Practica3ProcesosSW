use supermercados;

CREATE TABLE Articulo(
	id       int not null,
	nombre   varchar(50) not null,
	unidadesStock 		int not null,
	precio 		double not null,
	
	PRIMARY KEY (id)

);

INSERT INTO Articulo VALUES (1, "Leche", 80, 1.0);
INSERT INTO Articulo VALUES (2, "Pan", 30, 0.5);
INSERT INTO Articulo VALUES (3, "Huevos", 50, 1.5);
INSERT INTO Articulo VALUES (4, "Chocolate", 25, 1.0);