package boletin02_clasesArrays;
		
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
	 * primeros en un array y los 10 últimos en otro array. Por último, comparará
	 * ambos arrays y le dirá al usuario si son iguales o no
	 * -----------------------------------------------------------------------------
	 */

	// Creación del primer array
	int[] array1 = new int[10];

	// Creación del segundo array
	int[] array2 = new int[10];

	// Creación del scanner para leer el teclado del usuario
	Scanner sc = new Scanner(System.in);

	// Se le pregunta al usuario por los 20 valores enteros
	System.out.println("Introduzca 20 valores enteros: ");

	// Bucle for que recorre el primer array y almacena los 10 primeros números
	// enteros introducidos por el usuario
	for (int i = 0; i < array1.length; i++) {
		array1[i] = sc.nextInt();
	}

	// Bucle for que recorre el segundo array y almacena los 10 últimos números
	// enteros introducidos por el usuario
	for (int j = 0; j < array2.length; j++) {
		array2[j] = sc.nextInt();
	}

	// Ternario que comprueba si los arrays son iguales o no y lo imprime
	System.out.println(Arrays.equals(array1, array2) ? "Son iguales" : "No son iguales");

	// Cierre del scanner
		sc.close();

	}

}