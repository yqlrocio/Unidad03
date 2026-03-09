package boletin02_clasesArrays;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio03 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Crea un programa que cree un array de tamaño 30 y lo rellene con valores
	 * aleatorios entre 0 y 9. Luego ordena los valores del array y los mostrará por
	 * pantalla
	 * -----------------------------------------------------------------------------
	 */

	// Creación del array
	int[] array = new int[30];

	// Creación del random
	Random rnd = new Random();

	// Bucle for recorre el array asignándole un valor aleatorio entre 0 y 9
	for (int i = 0; i < array.length; i++) {
		array[i] = rnd.nextInt(0, 10);
	}

	// Se ordena el array
	Arrays.sort(array);

	// Se imprime el array
		System.out.println(Arrays.toString(array));

	}

}