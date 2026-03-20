package boletin06_collections02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		/*
		 * Implementa una aplicación que cree una lista de números enteros del 1 al 10 y luego la mezcle de forma aleatoria. 
		 * Finalmente, muestra la lista original y la lista mezclada por pantalla.
		 */

		/*
		 * Necesitamos: 
		 * 	- ArrayList -> lista ordenada del 1-10
		 * 	- ArrayList -> lista desordenada con valores del 1-10
		 */
		
		// Creamos scanner
		Scanner scanner = new Scanner(System.in);
		
		// Creamos random 
		Random random = new Random (); 
		
		// 1º LISTA: Creamos un ArrayList con números comprendidos desde 1 al 10
		ArrayList<Integer> numeros = new ArrayList<>(); 
		for (int i = 1; i < 10; i++) {
			int num = scanner.nextInt(10) + 1;
	        numeros.add(num);	
	        } // Fin del for
		
		// Ordenar la lista
		Collections.sort(numeros); 
		
		// 2º LISTA: Creamos un ArrayList con números comprendidos desde 1 al 10 con el tamaño aleatorio de la lista creado anteriormente
		ArrayList<Integer> numeros2 = new ArrayList<>(); 
		for (int i = 1; i < random.nextInt(); i++) {
			int num2 = scanner.nextInt(10) + 1;
	        numeros.add(num2);	
	        } // Fin del for
		
		// Mostrar por pantalla la lista ordenada y la aleatoria
		System.out.println("Lista ordenada: " + numeros);
		System.out.println("Lista ordenada: " + numeros2);
		
		// Cerrar scanner 
		scanner.close(); 
	}

}
