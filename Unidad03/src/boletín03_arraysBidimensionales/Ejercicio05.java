package boletín03_arraysBidimensionales;

import java.util.Random;

public class Ejercicio05 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Escribe un programa que genere 20 números enteros aleatorios entre 100 y 999.
	 * Estos números se deben introducir en un array de 4 filas por 5 columnas.
	 * Seguidamente, muestra el array por pantalla junto con las sumas parciales de
	 * filas y columnas, igual que si de una hoja de cálculo se tratara. La suma
	 * total debe aparecer en la esquina inferior derecha.
	 * -----------------------------------------------------------------------------
	 */

	// Creación del random
	Random rnd = new Random();

	// Variable para almacenar la suma de las filas
	int sumaFila = 0;

	// Variable para almacenar la suma total
	int sumaTotal = 0;

	// Array para los números que están en la tabla
	int[][] numeros = new int[4][5];

	// Array para la suma de columnas
	int[] sumaColumnas = new int[5];

	// Se rellena el array de los números con valores aleatorios
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 5; j++) {
			numeros[i][j] = rnd.nextInt(1, 1000);
		}
	}

	// Se imprime el array y las sumas de las filas
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 5; j++) {
			int valor = numeros[i][j];
			System.out.println(valor + " ");
			sumaFila = sumaFila + valor;
			sumaColumnas[j] += valor;
		}
		System.out.println("| " + sumaFila);
		sumaTotal += sumaFila;
	}

	// Se imprime la suma de las columnas
	for (int i = 0; i < 5; i++) {
		System.out.println(sumaColumnas[i] + " ");
	}

	// Se imprime la suma total
	System.out.println("| " + sumaTotal);

	}

}