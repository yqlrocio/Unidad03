package boletin02_clasesArrays;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio05 {

public static void main(String[] args) {

	/*
	 * -----------------------------------------------------------------------------
	 * Crea un programa que cree un array de tamaño 1000 y lo rellene con valores
	 * enteros aleatorios entre 0 y 99. Luego pedirá por teclado un valor y se
	 * mostrará por pantalla si ese valor existe en el array, además de cuántas
	 * veces
	 * -----------------------------------------------------------------------------
	 */

	// Variable para almacenar el número introducido por el usuario
	int numero;

	// Variable para el contador
	int contador = 0;

	// Creación del array
	int[] array = new int[100];

	// Creación del random
	Random rnd = new Random();

	// Creación del scanner para leer el teclado del usuario
	Scanner sc = new Scanner(System.in);

	// Bucle for que recorre las posiciones del array y les va asigna un valor entre
	// 0 y 99
	for (int i = 0; i < array.length; i++) {
		array[i] = rnd.nextInt(0, 100);
	}

	// Se le pregunta al usuario por el número que está buscando
	System.out.println("Introduzca un número entre 0 y 99: ");
	numero = sc.nextInt();

	// Bucle for que recorre las posiciones del array. Tiene un condicional que
	// comprueba si el número introducido por el usuario se encuentra en el array,
	// si se encuentra en el array el contador aumenta
	for (int j = 0; j < array.length; j++) {

		if (numero == array[j]) {
			contador++;
		}

	}

	// Ternario que comprueba si el número buscado existe en el array, si no existe
	// imrpime que no se encuentra, si sí existe imprime que sí se encuentra en el
	// array más el contador
	System.out.println(contador >= 1 ? "El valor existe en el array, se encuentra " + contador + " veces"
			: "El valor no se encuentra en el array");

	// Cierre del scanner
		sc.close();

	}

}
