db = db.getSiblingDB("clase");
db.createUser({
  user: "admin",
  pwd: "password",
  roles: [{ role: "readWrite", db: "clase" }]
});

db.persona.insertMany([
  { dni: 123, nombre: "Carlos", apellido: "Gomez", sexo: "M", edad: 20, grado: "Ingenieria", nota_media: 8.5 },
  { dni: 124, nombre: "Maria", apellido: "Lopez", sexo: "F", edad: 22, grado: "Medicina", nota_media: 9.0 },
  { dni: 125, nombre: "Luis", apellido: "Martinez", sexo: "M", edad: 19, grado: "Derecho", nota_media: 7.3 }
]);
