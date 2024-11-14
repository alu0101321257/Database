package Entrega;

public interface QueryExecutor {
    void executeQuery(String collectionName);
    void insert(String collectionName, String data);
    void delete(String collectionName, String condition); // Agrega este método para eliminaciones reales
}
