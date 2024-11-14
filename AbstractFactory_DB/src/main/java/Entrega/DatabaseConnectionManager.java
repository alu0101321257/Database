package Entrega;

import java.util.Scanner;

public class DatabaseConnectionManager {
    private Scanner scanner;

    public DatabaseConnectionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public QueryExecutor initializeConnection() {
        System.out.print("Ingrese la URL de la base de datos: ");
        String url = scanner.nextLine();

        DatabaseFactory factory = createFactoryBasedOnUrl(url);
        if (factory == null) {
            System.out.println("URL no reconocida. Asegúrese de ingresar una URL válida para MySQL, PostgreSQL o MongoDB.");
            return null;
        }

        DBConnection connection = factory.createConnection(url, "", "");

        if (!connection.connect()) {
            System.out.println("La base de datos requiere autenticación.");
            System.out.print("Ingrese el nombre de usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingrese la contraseña: ");
            String password = scanner.nextLine();

            connection = factory.createConnection(url, username, password);

            if (!connection.connect()) {
                System.out.println("Error de autenticación. Revise las credenciales y vuelva a intentar.");
                return null;
            }
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Conexión establecida exitosamente.");
        }

        return factory.createQueryExecutor(connection);
    }

    private DatabaseFactory createFactoryBasedOnUrl(String url) {
        if (url.contains("mysql")) {
            return new MySQLDatabaseFactory();
        } else if (url.contains("postgresql")) {
            return new PostgreSQLDatabaseFactory();
        } else if (url.contains("mongodb")) {
            return new MongoDBDatabaseFactory();
        }
        return null;
    }
}
