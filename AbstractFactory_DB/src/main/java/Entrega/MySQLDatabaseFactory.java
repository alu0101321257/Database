package Entrega;

public class MySQLDatabaseFactory implements DatabaseFactory {
    public DBConnection createConnection(String url, String username, String password) {
        return new MySQLConnection(url, username, password);
    }

    public QueryExecutor createQueryExecutor(DBConnection connection) {
        return new MySQLQueryExecutor(connection);
    }
}
