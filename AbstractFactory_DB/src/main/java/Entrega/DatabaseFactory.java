package Entrega;

public interface DatabaseFactory {
    DBConnection createConnection(String url, String username, String password);
    QueryExecutor createQueryExecutor(DBConnection connection);
}
