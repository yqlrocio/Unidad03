package boletin01_arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {

		/*
		 * Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con
		 * valores enteros aleatorios entre 1 y 10. Luego pedirá un valor N y mostrará
		 * en qué posiciones del array aparece N.
		 */
		
		// Create a Scanner
		Scanner sc = new Scanner(System.in);

		// Create a Random Generator
		Random rand = new Random();

		// The number introduced by the user
		int num;

		// The place where the number is located in the table
		int place;

		// The table where all the numbers will be saved
		int table[] = new int[100];

		// We want to fill the table with random numbers
		for (int i = 0; i < table.length; i++) {
			table[i] = rand.nextInt(1, 11);
		}

		// Now, the user has to introduce a number from 1-10
		System.out.println("Introduzca un número del 1 al 10:");
		num = sc.nextInt();

		// First, we order the table
		Arrays.sort(table);

		// Once the table is ordered, we search the number introduced by the user in it
		place = Arrays.binarySearch(table, num);

		// We show the place in the console
		if (num >= 0) {
			System.out.println("El número se encuentra en el índice " + place);
		} else {
			System.out.println("No se ha encontrado su número");
		}

		// Close Scanner
		sc.close();

	}

}