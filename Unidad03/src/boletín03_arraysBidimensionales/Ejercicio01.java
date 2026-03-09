package boletín03_arraysBidimensionales;

import java.util.Arrays;

public class Ejercicio01 {

	public static void main(String[] args) {

		/*
		 * -----------------------------------------------------------------------------
		 * Define un array de números enteros de 3 filas por 6 columnas con nombre num y
		 * asigna los valores según la siguiente tabla. Muestra el contenido de todos
		 * los elementos del array dispuestos en forma de tabla como se muestra en la
		 * figura
		 * -----------------------------------------------------------------------------
		 */

		// Creación del array
		int[][] num = new int[3][6];

		// Asignación de valores
		num[0][0] = 0;
		num[0][1] = 30;
		num[0][2] = 2;
		num[0][5] = 5;
		num[1][0] = 75;
		num[1][4] = 0;
		num[2][2] = -2;
		num[2][3] = 9;
		num[2][5] = 11;

		// Bucle for que recorre las filas y las columnas del array
		for (int i = 0; i < num.length; i++) {
			System.out.println(Arrays.toString(num[i]));
		}

		System.out.println("Otra forma de hacerlo");

		// Bucle for que recorre las filas del array
		for (int i = 0; i < num.length; i++) {

			// Bucle for que recorre las columnas del array
			for (int j = 0; j < num[i].length; j++) {

				// Imprime la fila y la columna del array
				System.out.print(num[i][j] + "\t");
			}

			System.out.println();

		}

		// Muestra las tablas en forma de fila del tirón
		// System.out.println(Arrays.deepToString(num));

	}

}