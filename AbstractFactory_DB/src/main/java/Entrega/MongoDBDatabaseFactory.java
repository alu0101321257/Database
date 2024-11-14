package Entrega;

public class MongoDBDatabaseFactory implements DatabaseFactory {

    @Override
    public DBConnection createConnection(String url, String username, String password) {
        // La base de datos predeterminada para conexión y autenticación
        String databaseName = "clase"; // Cambia si necesitas otro nombre de base de datos
        return new MongoDBConnection(url, username, password, databaseName);
    }

    @Override
    public QueryExecutor createQueryExecutor(DBConnection connection) {
        return new MongoDBQueryExecutor(connection);
    }
}