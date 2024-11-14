package Entrega;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBQueryExecutor implements QueryExecutor {
    private final MongoDBConnection dbConnection;

    public MongoDBQueryExecutor(DBConnection dbConnection) {
        this.dbConnection = (MongoDBConnection) dbConnection;
    }

    @Override
    public void executeQuery(String collectionName) {
        MongoDatabase database = dbConnection.getDatabase();
        MongoCollection<Document> collection = database.getCollection(collectionName);

        System.out.println("Consultando todos los documentos en la colección '" + collectionName + "':");
        for (Document doc : collection.find()) {
            System.out.println("Resultado: " + doc.toJson());
        }
    }

    @Override
    public void insert(String collectionName, String data) {
        MongoDatabase database = dbConnection.getDatabase();
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document document = Document.parse(data);
        collection.insertOne(document);
        System.out.println("Documento insertado en MongoDB exitosamente.");
    }

    @Override
    public void delete(String collectionName, String condition) {
        MongoDatabase database = dbConnection.getDatabase();
        MongoCollection<Document> collection = database.getCollection(collectionName);

        // Convierte la condición a un documento BSON
        Document filter = Document.parse(condition);
        long deletedCount = collection.deleteMany(filter).getDeletedCount();
        System.out.println("Se eliminaron " + deletedCount + " documentos de MongoDB.");
    }
}