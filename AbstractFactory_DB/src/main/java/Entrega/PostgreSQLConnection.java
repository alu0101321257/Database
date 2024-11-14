package Entrega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection implements DBConnection {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public PostgreSQLConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado a PostgreSQL exitosamente.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al conectar a PostgreSQL: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desconectado de PostgreSQL.");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar de PostgreSQL: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}