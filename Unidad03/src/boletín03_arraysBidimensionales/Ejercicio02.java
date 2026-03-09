package boletín03_arraysBidimensionales;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
	/*
	 * -----------------------------------------------------------------------------
	 * Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados
	 * “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las
	 * notas por teclado y luego el programa mostrará la tabla con las notas. A
	 * continuación, mostrará la nota mínima, máxima y media de cada alumno
	 * -----------------------------------------------------------------------------
	 */

	// Array para los alumnos
	String[] alumnos = { "Alumno 1", "Alumno 2", "Alumno 3", "Alumno 4" };

	// Array para las notas
	double[][] notas = new double[5][4];

	// Variable para la suma de las notas
	double suma = 0;

	// Variable para comprobar la nota máxima
	double max = Double.MIN_VALUE;

	// Variable para comprobar la nota máxima
	double min = Double.MAX_VALUE;

	// Creación del scanner para leer el teclado del usuario
	Scanner sc = new Scanner(System.in);

	// Bucle for que recorre las columnas del array de las notas
	for (int i = 0; i < notas[i].length; i++) {

		// Se le pregunta al usuario por las notas de los alumnos
		System.out.println("Introduzca la nota del alumno " + (i + 1) + ": ");

		// Bucle for que almacena las notas del alumno
		for (int j = 0; j < notas.length; j++) {
			notas[j][i] = sc.nextDouble();
		}

		System.out.println("-----------------------------------------------------------------------------");
	}

	// Bucle for que recorre el array de los alumnos e imprime sus nombres
	for (int k = 0; k < alumnos.length; k++) {
		System.out.print(alumnos[k] + "\t");
	}

	System.out.println();

	// Bucle for que recorre el array de las notas
	for (int m = 0; m < notas.length; m++) {

		// Bucle for que imprime las notas de los alumnos
		for (int n = 0; n < notas[m].length; n++) {
			System.out.print(notas[m][n] + "\t" + "\t");
		}

		System.out.println();

	}

	// Bucle for que recorre las posiciones del array de las notas
	for (int i = 0; i < notas[i].length; i++) {
		System.out.println("Notas del alumno " + (i + 1) + ": ");

		// Bucle for que recorre las columnas del array de las notas y va sumando las
		// notas de los alumnos
		for (int j = 0; j < notas.length; j++) {
			suma += notas[j][i];

			// Condicional if que comprueba la nota máxima y la mínima
			if (notas[j][i] < min) {
				min = notas[j][i];
			}

			if (notas[j][i] > max) {

				max = notas[j][i];
			}

		}

		// Se imprime la nota máxima, mínima y la media de cada alumno
		System.out.println("Nota máxima: " + max);
		System.out.println("Nota mínima: " + min);
		System.out.println("Nota media: " + suma / notas.length);
		System.out.println();

		// Se resetean los valores para el próximo alumno
		suma = 0;
		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;
	}

	// Cierre del scanner
	sc.close();

	}

}