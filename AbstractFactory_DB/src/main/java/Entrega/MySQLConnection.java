package Entrega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements DBConnection {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public MySQLConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado a MySQL exitosamente.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al conectar a MySQL: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desconectado de MySQL.");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar de MySQL: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
