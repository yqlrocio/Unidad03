package boletin05_collections01;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		/*
		 * Introduce por teclado, hasta que se introduzca “fin”, 
		 * una serie de nombres, que se insertarán en una colección, 
		 * de forma que se conserve el orden de inserción y que no 
		 * puedan repetirse. Al final, la colección se mostrará por 
		 * pantalla.
		 */
		
		/**
		 * Necesitamos: 
		 * - LinkedHash -> conservar el orden de lo introducido
		 * - equalsIgnoreCase -> no repetir nombres
		 * - Pedir al usuario que escriba nombres hasta que escriba "fin"
		 * - Mostrar por pantalla -> la lista de nombres hasta "fin"
		 */

		Scanner scanner = new Scanner(System.in);

	    // LinkedHashSet conserva el orden y no permite duplicados
	    LinkedHashSet<String> nombres = new LinkedHashSet<>();

	    System.out.println("Introduce nombres (escribe 'fin' para terminar):");

	    while (true) {
	    	String nombre = scanner.nextLine();

	    	if (nombre.equalsIgnoreCase("fin")) { // Si escribe "fin", se termina
	    		break;
	    	}

	    	// Añade el nombre al conjunto (si ya existe, no se añade)
	    	if (nombres.add(nombre)) {
	    		System.out.println("Añadido: " + nombre);
	    	} else {
	    		System.out.println("Ya estaba en la lista: " + nombre);
        		}
	    	}

	    // Mostrar la colección final
	    System.out.println("\nNombres introducidos (sin repetidos, en orden):");
	    System.out.println(nombres);
	    
	    // Cerrar Scanner
	    scanner.close();

	} // Fin del main

} // Fin de la clase Ejercicio05
