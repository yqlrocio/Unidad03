package boletin05_collections01;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio06 {

	public static void main(String[] args) {
		
		/*----------------------------------------------------------------
		 * Repite la actividad anterior de forma que se inserten 
		 * los nombres manteniendo el orden alfabético.
		 *----------------------------------------------------------------
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
	    TreeSet<String> nombres = new TreeSet<>();

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
	    System.out.println("\nNombres introducidos (sin repetidos, en orden alfabético):");
	    System.out.println(nombres);
	    
	    // Cerrar Scanner
	    scanner.close();

	} // Fin del main

} // Fin de la clase Ejercicio06
