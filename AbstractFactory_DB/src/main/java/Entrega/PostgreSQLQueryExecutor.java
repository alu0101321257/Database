package Entrega;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLQueryExecutor implements QueryExecutor {
    private DBConnection dbConnection;

    public PostgreSQLQueryExecutor(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void executeQuery(String tableName) {
        Connection connection = ((PostgreSQLConnection) dbConnection).getConnection();
        try (Statement stmt = connection.createStatement()) {
            String query = "SELECT * FROM " + tableName;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Resultado: " + rs.getString(1)); // Ajusta según la estructura de tu tabla
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta en PostgreSQL: " + e.getMessage());
        }
    }

    @Override
    public void insert(String tableName, String data) {
        Connection connection = ((PostgreSQLConnection) dbConnection).getConnection();
        try (Statement stmt = connection.createStatement()) {
            String query = "INSERT INTO " + tableName + " VALUES " + data;
            stmt.executeUpdate(query);
            System.out.println("Inserción exitosa en PostgreSQL.");
        } catch (SQLException e) {
            System.out.println("Error al insertar en PostgreSQL: " + e.getMessage());
        }
    }

    @Override
    public void delete(String tableName, String condition) {
        Connection connection = ((PostgreSQLConnection) dbConnection).getConnection();
        try (Statement stmt = connection.createStatement()) {
            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            int rowsDeleted = stmt.executeUpdate(query);
            System.out.println("Se eliminaron " + rowsDeleted + " filas de PostgreSQL.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar en PostgreSQL: " + e.getMessage());
        }
    }
}