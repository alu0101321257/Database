CREATE DATABASE zapateria;
\c zapateria;

CREATE TABLE IF NOT EXISTS tienda (
    id_zapato INT PRIMARY KEY,
    talla INT,
    color VARCHAR(20),
    marca VARCHAR(20),
    unidades INT
);

INSERT INTO tienda (id_zapato, talla, color, marca, unidades) VALUES
(12345, 42, 'Rojo', 'Nike', 10),
(12346, 38, 'Azul', 'Adidas', 5),
(12347, 40, 'Negro', 'Puma', 8);
