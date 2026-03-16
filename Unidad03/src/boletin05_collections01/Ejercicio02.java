package boletin05_collections01;

import java.util.ArrayList;
import java.util.Random;

public class Ejercicio02 {

	public static void main(String[] args) {
		//--------------------------------------------------------------------------------------------------------------
		/*
		 * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un ArrayList y que luego calcule 
		 * la suma, la media, el máximo y el mínimo de esos números. El tamaño de la lista también será aleatorio y 
		 * podrá oscilar entre 5 y 10 elementos ambos inclusive.
		*/ 
		//--------------------------------------------------------------------------------------------------------------

		/**
		 * Necesitamos: 
		 * - ArrayList -> valores aleatorios entre 0-100
		 * - Variables para almacenar las operaciones -> suma, media, nº máx. y nº mín. de los números introducidos
		 * - Tamaño de la lista -> Random que nos cree números aleatorios del 5-10
		 */

		// Creamos random y una variable para almacenar el tamaño de la lista
		Random random = new Random (); 
		int tamaño = random.nextInt(6) + 5; // números desde 5 hasta 10
		
		// Creamos un ArrayList con números comprendidos desde 0 al 100 con el tamaño aleatorio de la lista creado anteriormente
		ArrayList<Integer> numeros = new ArrayList<>(); 
		for (int i = 0; i < tamaño; i++) {
			numeros.add(random.nextInt(101)); 
		} // Fin del for
	
		// Mostrar por pantalla los números
		System.out.println("Numeros generados: " + numeros);
		
		// Calcular suma, nº máx., nº mín. y media
		int suma = 0; 
		int max = numeros.get(0); 
		int min = numeros.get(0);

		for (int num : numeros) {
			suma += num; 
			
			if (num < min) {
				min = num;
			} // Fin del if

			if (num > max) {
				max = num;
			} // Fin del if

		} // Fin del for
		
		double media = suma/numeros.size(); 
		
		// Mostrar por pantalla las operaciones
		System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        
	} // Fin del main

} // Fin de la clase Ejercicio02
