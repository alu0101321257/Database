FROM postgres:latest
ENV POSTGRES_PASSWORD=password
COPY ./init.sql /docker-entrypoint-initdb.d/init.sql
EXPOSE 5432
