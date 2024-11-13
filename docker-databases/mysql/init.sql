CREATE DATABASE IF NOT EXISTS automoviles;
USE automoviles;

CREATE TABLE IF NOT EXISTS coche (
    matricula CHAR(4) NOT NULL,
    marca VARCHAR(10),
    numero_puertas INT,
    color VARCHAR(7),
    tipo VARCHAR(10)
);

INSERT INTO coche (matricula, marca, numero_puertas, color, tipo) VALUES
('1234', 'Toyota', 4, 'Rojo', 'Sedan'),
('5678', 'Honda', 2, 'Azul', 'Coupe'),
('9101', 'Ford', 4, 'Blanco', 'SUV'),
('1121', 'Tesla', 4, 'Negro', 'Electrico'),
('3141', 'Mazda', 4, 'Gris', 'Sedan');
