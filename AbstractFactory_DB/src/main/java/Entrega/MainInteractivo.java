package Entrega;

import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(scanner);

        System.out.println("=== Bienvenido al sistema de conexión de base de datos ===");

        QueryExecutor executor = connectionManager.initializeConnection();
        if (executor == null) {
            System.out.println("Error al conectar a la base de datos. Cerrando el programa.");
            scanner.close();
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSeleccione una acción:");
            System.out.println("1. Consultar todos los registros en una tabla/colección");
            System.out.println("2. Insertar un nuevo registro en una tabla/colección");
            System.out.println("3. Eliminar registros por condición");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre de la tabla/colección a consultar: ");
                    String consultaCollection = scanner.nextLine();
                    System.out.println("\nConsultando todos los registros en '" + consultaCollection + "':");
                    executor.executeQuery(consultaCollection);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre de la tabla/colección donde insertar: ");
                    String insertCollection = scanner.nextLine();
                    System.out.print("Ingrese los datos en formato JSON para MongoDB o SQL para MySQL/PostgreSQL (ej. '{ \"dni\": 126, \"nombre\": \"Ana\" }'): ");
                    String datos = scanner.nextLine();
                    executor.insert(insertCollection, datos);
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la tabla/colección: ");
                    String deleteCollection = scanner.nextLine();
                    System.out.print("Ingrese la condición de eliminación (ej. 'id=123' para SQL o '{ \"nombre\": \"Carlos\" }' para MongoDB): ");
                    String condition = scanner.nextLine();
                    executor.delete(deleteCollection, condition);
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        System.out.println("Desconexión exitosa.");
        scanner.close();
    }
}
