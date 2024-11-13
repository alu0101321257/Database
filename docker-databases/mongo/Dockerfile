FROM mongo:latest

ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=password

COPY ./init-mongo.js /docker-entrypoint-initdb.d/init-mongo.js
EXPOSE 27017
    