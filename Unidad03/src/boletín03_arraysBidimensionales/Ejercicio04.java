package boletín03_arraysBidimensionales;

public class Ejercicio04 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Escribe un programa que cree una tabla de 10x10 que contenga los valores de
	 * las tablas de multiplicar del 1 al 10 (cada tabla de multiplicar en una
	 * fila). Muestra la tabla por pantalla
	 * -----------------------------------------------------------------------------
	 */

	// Variable para la multiplicación
	int num = 1;

	// Creación del array
	int[][] array = new int[10][10];

	// Bucle for que recorre las filas del array
	for (int i = 0; i < array.length; i++) {

		// Bucle for que recorre las columnas del array
		for (int j = 0; j < array.length; j++) {
			// Uso de las columnas para imprimir la multiplicación
			array[i][j] = j + 1;
			// Se imprime la multiplicación
			System.out.print(array[i][j] + "*" + num + "=" + array[i][j] * num + "\t" + "\t");
		}
		// Se incrementa el auxiliar de la multiplicación
			num++;
			System.out.println();
		}

	}

}