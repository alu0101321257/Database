FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD=password
COPY ./init.sql /docker-entrypoint-initdb.d/init.sql
EXPOSE 3306
