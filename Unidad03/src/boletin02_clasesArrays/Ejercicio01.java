package boletin02_clasesArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {

public static void main(String[] args) {
	
	/*
	 * -----------------------------------------------------------------------------
	 * Crea un programa que pida al usuario dos valores, tamaño y valor, y luego
	 * cree un array del tamaño dado y que almacene valor en todas sus posiciones.
	 * Luego muestra el array por pantalla
	 * -----------------------------------------------------------------------------
	 */

	// Variable para el tamaño del array
	int tamano;

	// Variable para el valor del array
	int valor;

	// Creación del scanner para leer el teclado del usuario
	Scanner sc = new Scanner(System.in);

	// Se le pregunta al usuario por el tamaño y el valor del array
	System.out.println("Introduzca el tamaño del array: ");
	tamano = sc.nextInt();

	System.out.println("Introduzca el valor del array: ");
	valor = sc.nextInt();

	// Creación del array
	int[] array = new int[tamano];

	// Se rellena el array con el valor que ha introducido el usuario
	Arrays.fill(array, valor);

	// Se imprime el array
	System.out.println(Arrays.toString(array));

	// Cierre del scanner
				sc.close();

	}

}
	


