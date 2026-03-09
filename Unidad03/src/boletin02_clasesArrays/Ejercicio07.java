package boletin02_clasesArrays;

import java.util.Arrays;

public class Ejercicio07 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Crea un programa que cree un array de tipo entero e introduzca la siguiente
	 * secuencia de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta
	 * introducir 10 diez veces el 10, y luego la muestre por pantalla. En esta
	 * ocasión has de utilizar Arrays.fill()
	 * -----------------------------------------------------------------------------
	 */

	// Variable para el inicio
	int inicio = 0;

	// Creación del array
	int[] array = new int[55];

	// Bucle for que va del 1 al 10
	for (int i = 0; i <= 10; i++) {
		// Arrays.fill que almacena el número en el array, empieza a almacenarlo en
		// inicio hasta inicio + i y escribe i
		Arrays.fill(array, inicio, inicio + i, i);
		// Incrementamos el valor de inicio sumándole el valor de i
		inicio += i;
	}

	// Se imprime el array
		System.out.println(Arrays.toString(array));

	}

}