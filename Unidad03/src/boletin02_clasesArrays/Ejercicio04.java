package boletin02_clasesArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Necesitamos crear un programa para mostrar el ranking de puntuaciones de un
	 * torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que introduzca las
	 * puntuaciones de todos los jugadores (habitualmente valores entre 1000 y 2800,
	 * de tipo entero) y luego muestre las puntuaciones en orden descendente (de la
	 * más alta a la más baja)
	 * -----------------------------------------------------------------------------
	 */

	// Creación del array
	Integer[] array = new Integer[8];

	// Creación del scanner para leer el teclado del usuario
	Scanner sc = new Scanner(System.in);

	// Bucle for que recorre el array preguntando por la puntuación de cada jugador
	// y va almacenando en el array
	for (int i = 0; i < array.length; i++) {
		System.out.println("Jugador " + (i + 1) + ", cuál es su puntuación? ");
		array[i] = sc.nextInt();
	}

	// Se ordena el array en orden descendente
	Arrays.sort(array, Collections.reverseOrder());

	System.out.println("Clasificación del torneo de ajedrez: ");

	// Se imprime el array ya ordenado
	for (int j = 0; j < array.length; j++) {
		System.out.println(array[j]);
	}

	// Cierre del scanner
		sc.close();

	}

}