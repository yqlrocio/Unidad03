package boletín03_arraysBidimensionales;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Escribe un programa que pida las dimensiones de una tabla bidimensional al
	 * usuario (número de filas y número de columnas). A continuación, crea dicha
	 * tabla bidimensional y rellénala de la siguiente forma: el elemento de la
	 * posición [i][j] debe contener el valor 10 * i + j. A continuación, muestra la
	 * tabla por consola
	 * -----------------------------------------------------------------------------
	 */

	// Variables para las dimensiones del array bidimensional
	int filas = 0;
	int columnas = 0;

	// Creación del scanner para leer el teclado del usuario
	Scanner sc = new Scanner(System.in);

	// Se le pregunta al usuario por las dimensiones del array bidimensional
	System.out.println("Introduzca el número de filas del array: ");
	filas = sc.nextInt();

	System.out.println("Introduzca el número de columnas del array: ");
	columnas = sc.nextInt();

	// Creación del array bidimensional
	int[][] array = new int[filas][columnas];

	// Bucle for que recorre las filas del array
	for (int i = 0; i < filas; i++) {

		// Bucle for que recorre las columnas del array
		for (int j = 0; j < columnas; j++) {
			// Asigna valor a la posición
			array[i][j] = 10 * i + j;
			// Imprime el mensaje
			System.out.print(array[i][j] + "\t");
		}
		System.out.println();
	}

	// Cierre del scanner
		sc.close();

	}

}