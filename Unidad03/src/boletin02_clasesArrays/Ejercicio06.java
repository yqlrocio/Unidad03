package boletin02_clasesArrays;

import java.util.Random;

public class Ejercicio06 {

	public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Realiza un programa que cree dos tablas, la primera con los 6 números de una
	 * apuesta de la primitiva generados aleatoriamente entre 1 y 49 y, la segunda
	 * (ordenada) con los 6 números de la combinación ganadora. La combinación
	 * ganadora debe establecerse en el momento de crear la tabla. El programa
	 * devolverá el número de aciertos
	 * -----------------------------------------------------------------------------
	 */

	// Variable para los aciertos
	int aciertos = 0;

	// Creación del array para la primitiva
	int[] primitiva = new int[6];

	// Creación del array de la combinación ganadora
	int[] combinacionGanadora = { 8, 18, 21, 28, 38, 47, 48 };

	// Creación del random
	Random rnd = new Random();

	// Bucle for que recorre las posiciones del array de la primitiva asignando
	// valores aleatorios entre 1 y 49. Tiene un condicional if dentro que comprueba
	// los aciertos e incrementa el contador de aciertos
	for (int i = 0; i < primitiva.length; i++) {
		primitiva[i] = rnd.nextInt(1, 50);

		if (primitiva[i] == combinacionGanadora[i]) {
			aciertos++;
		}

	}

	// Se imprime el número de aciertos
	System.out.println("Números de aciertos: " + aciertos);

	}

}