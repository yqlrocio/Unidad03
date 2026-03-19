package boletin05_collections01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio10 {

	/**
	 * Programa que me almacene los productos con su precio correspondiente.
	 * Permitiendo dar de añadir, quitar o mostrar un producto a partir de un menú.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Realiza una aplicación donde se registren nombres de productos y su precio. Lleva a cabo el siguiente menú:
		//		PRODUCTOS
		//		1. Alta de producto
		//		2. Baja de producto
		//		4. Listar existencias
		//		0. Salir
		//		El orden en el que se almacenan los productos no importa.

		Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        int opcion;

        do {
            System.out.println("PRODUCTOS");
            System.out.println("1. Alta de producto");
            System.out.println("2. Baja de producto");
            System.out.println("4. Listar existencias");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                // Alta de producto
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Precio: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();

                nombres.add(nombre);
                precios.add(precio);

                System.out.println("Producto añadido\n");

            } else if (opcion == 2) {
                // Baja de producto
                System.out.print("Nombre a eliminar: ");
                String nombre = scanner.nextLine();

                boolean encontrado = false;

                for (int i = 0; i < nombres.size(); i++) {
                    if (nombres.get(i).equalsIgnoreCase(nombre)) {
                        nombres.remove(i);
                        precios.remove(i);
                        encontrado = true;
                        System.out.println("Producto eliminado\n");
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("No encontrado\n");
                }

            } else if (opcion == 4) {
                // Listar productos
                if (nombres.isEmpty()) {
                    System.out.println("No hay productos\n");
                } else {
                    for (int i = 0; i < nombres.size(); i++) {
                        System.out.println(nombres.get(i) + " - " + precios.get(i) + "€");
                    }
                    System.out.println();
                }

            } else if (opcion == 0) {
                System.out.println("Adiós");

            } else {
                System.out.println("Opción incorrecta\n");
            }

        } while (opcion != 0);
    }
}
