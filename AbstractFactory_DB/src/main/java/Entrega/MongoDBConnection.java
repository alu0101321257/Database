package Entrega;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection implements DBConnection {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private final String url;
    private final String databaseName;

    public MongoDBConnection(String url, String username, String password, String databaseName) {
        // Si el URL no incluye credenciales, las agregamos con la base de autenticación 'admin'
        if (url.contains("mongodb://") && url.contains("@")) {
            this.url = url;
        } else {
            this.url = String.format("mongodb://%s:%s@%s/admin", username, password, url.replace("mongodb://", ""));
        }
        this.databaseName = databaseName;
    }

    @Override
    public boolean connect() {
        try {
            mongoClient = MongoClients.create(url);
            database = mongoClient.getDatabase(databaseName); // Accede a 'clase' después de autenticar en 'admin'
            System.out.println("Conexión exitosa a MongoDB.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al conectar a MongoDB: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Desconexión exitosa de MongoDB.");
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}