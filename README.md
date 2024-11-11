# Database

## Creacion de la base de datos MYSQL

1. Se instala haciendo uso de doker --> docker run -d --name oracle-db -p 1521:1521 -e ORACLE_PWD=password oracle/database:latest
2. Accede a Oracle desde SQL*Plus en Docker --> docker exec -it oracle-db sqlplus sys/password@//localhost:1521/ORCLCDB as sysdba

3. Creamos la base de datos con: 
CREATE DATABASE automoviles;
USE automoviles;

4. Creamos la tabla para la base de datos 
CREATE TABLE coche (
    matricula CHAR(4) NOT NULL,
    marca VARCHAR(10),
    numero_puertas INT,
    color VARCHAR(7),
    tipo VARCHAR(10)
);

5. Insertamos los valores para la tabla de nuestra base de datos: 
INSERT INTO coche (matricula, marca, numero_puertas, color, tipo) VALUES
('1234', 'Toyota', 4, 'Rojo', 'Sedan'),
('5678', 'Honda', 2, 'Azul', 'Coupe'),
('9101', 'Ford', 4, 'Blanco', 'SUV'),
('1121', 'Tesla', 4, 'Negro', 'Electrico'),
('3141', 'Mazda', 4, 'Gris', 'Sedan');

6. Visualizamos los datos con 
SELECT * FROM coche;

**Para conectarnos a la base de datos creada**
1. docker exec -it mysql-db mysql -u root -p 
2. USE automoviles;
3. SELECT * FROM coche;


## Creacion de la base de datos Mongo DB 
1. Usamos Docker para iniciar un contenedor de MongoDB --> docker run --name mongo-db -p 27017:27017 -d mongo
2. Nos conectamos a mongo : mongo --host localhost --port 27017
3. Selecionamos la base de datos a usar --> use clase
4. Creamos las tablas : 
db.persona.insertMany([
  {
    dni: 123,
    nombre: "Carlos",
    apellido: "Gomez",
    sexo: "M",
    edad: 20,
    grado: "Ingenieria",
    nota_media: 8.5
  },
  {
    dni: 124,
    nombre: "Maria",
    apellido: "Lopez",
    sexo: "F",
    edad: 22,
    grado: "Medicina",
    nota_media: 9.0
  },
  {
    dni: 125,
    nombre: "Luis",
    apellido: "Martinez",
    sexo: "M",
    edad: 19,
    grado: "Derecho",
    nota_media: 7.3
  }
])

5. Consultamos los datos añadidos: 
db.persona.find().pretty()

**Como conectarnos a Mongo Db**
1. mongo --host localhost --port 27017
2. use clase
3. db.persona.find().pretty()

## Creacion de una base de datos con POSTGRES 
1. creamos la base de datos --> docker run --name postgres-db -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
2. nos conectamos a la base de datos --> docker exec -it postgres-db psql -U postgres
3. Creamos la base de datos --> CREATE DATABASE zapateria;
4. nos conectamos a la base de datos --> \c zapateria
5. Creamos la tabla: 
CREATE TABLE tienda (
    id_zapato INT PRIMARY KEY,
    talla INT,
    color VARCHAR(20),
    marca VARCHAR(20),
    unidades INT
);

5. Añadimos los valores: 
INSERT INTO tienda (id_zapato, talla, color, marca, unidades) VALUES
(12345, 42, 'Rojo', 'Nike', 10),
(12346, 38, 'Azul', 'Adidas', 5),
(12347, 40, 'Negro', 'Puma', 8);

6. Revismaos que los valores esten bien añadidos --> SELECT * FROM tienda;

**Para conectarnos a la base de datos POSTGRES**
 docker exec -it postgres-db psql -U postgres
 \c zapateria
SELECT * FROM tienda;





