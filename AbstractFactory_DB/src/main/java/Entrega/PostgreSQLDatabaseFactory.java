package Entrega;

public class PostgreSQLDatabaseFactory implements DatabaseFactory {
    public DBConnection createConnection(String url, String username, String password) {
        return new PostgreSQLConnection(url, username, password);
    }

    public QueryExecutor createQueryExecutor(DBConnection connection) {
        return new PostgreSQLQueryExecutor(connection);
    }
}