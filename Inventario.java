package Programa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventario {
    private static Map<String, Integer> inventario = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Establecer el inventario inicialmente con los productos
        inventario.put("Mazapán", 100);
        inventario.put("Chocolate", 100);
        inventario.put("Galletas", 100);
        inventario.put("Toffee", 100);
        inventario.put("Turrón", 100);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar ingreso de productos");
            System.out.println("2. Registrar salida de productos");
            System.out.println("3. Consultar inventario");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (opcion == 1) {
                ingresarProducto();
            } else if (opcion == 2) {
                sacarProducto();
            } else if (opcion == 3) {
                consultarInventario();
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void ingresarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String producto = scanner.nextLine();
        System.out.println("Ingrese la cantidad de productos que ingresan:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        if (inventario.containsKey(producto)) {
            inventario.put(producto, inventario.get(producto) + cantidad);
            System.out.println("Ingreso registrado correctamente.");
        } else {
            inventario.put(producto, cantidad);
            System.out.println("Producto agregado al inventario.");
        }
    }

    private static void sacarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String producto = scanner.nextLine();
        System.out.println("Ingrese la cantidad de productos que salen:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        if (inventario.containsKey(producto) && inventario.get(producto) >= cantidad) {
            inventario.put(producto, inventario.get(producto) - cantidad);
            System.out.println("Salida registrada correctamente.");
        } else {
            System.out.println("Producto no encontrado o cantidad insuficiente.");
        }
    }

    private static void consultarInventario() {
        System.out.println("Ingrese el nombre del producto para consultar su inventario:");
        String producto = scanner.nextLine();

        if (inventario.containsKey(producto)) {
            System.out.println("Inventario de " + producto + ": " + inventario.get(producto));
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }
}
