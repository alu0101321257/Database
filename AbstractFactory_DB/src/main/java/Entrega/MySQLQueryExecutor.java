package Entrega;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLQueryExecutor implements QueryExecutor {
    private DBConnection dbConnection;

    public MySQLQueryExecutor(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void executeQuery(String tableName) {
        Connection connection = ((MySQLConnection) dbConnection).getConnection();
        try (Statement stmt = connection.createStatement()) {
            String query = "SELECT * FROM " + tableName;
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                StringBuilder row = new StringBuilder("Resultado: ");
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String value = rs.getString(i);
                    row.append(columnName).append("=").append(value);
                    if (i < columnCount) row.append(", ");
                }
                System.out.println(row);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta en MySQL: " + e.getMessage());
        }
    }

    @Override
    public void insert(String tableName, String data) {
        Connection connection = ((MySQLConnection) dbConnection).getConnection();
        try (Statement stmt = connection.createStatement()) {
            String query = "INSERT INTO " + tableName + " VALUES " + data;
            stmt.executeUpdate(query);
            System.out.println("Inserción exitosa en MySQL.");
        } catch (SQLException e) {
            System.out.println("Error al insertar en MySQL: " + e.getMessage());
        }
    }

    @Override
    public void delete(String tableName, String condition) {
        Connection connection = ((MySQLConnection) dbConnection).getConnection();
        try (Statement stmt = connection.createStatement()) {
            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            int rowsDeleted = stmt.executeUpdate(query);
            System.out.println("Se eliminaron " + rowsDeleted + " filas de MySQL.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar en MySQL: " + e.getMessage());
        }
    }
}
