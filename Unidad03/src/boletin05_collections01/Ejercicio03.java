package boletin05_collections01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		/*
		 * Realiza un programa que genere 30 números enteros aleatorios, 
		 * con valores comprendidos entre 1 y 10. Se deben almacenar en 
		 * una colección de forma ordenada. Pinta la colección por consola
		 * una vez rellena.
		 */

		/**
		 * Necesitamos: 
		 * - Tamaño de la lista -> 30 valores aleatorios 
		 * - Valores aleatorios -> desde 1-10
		 * - Lista ordenada
		 * - Mostrar por pantalla
		 */
		
	// Creamos random 
	Random random = new Random (); 
	
	// Creamos un ArrayList con números comprendidos desde 0 al 10 con el tamaño aleatorio de la lista creado anteriormente
	ArrayList<Integer> numeros = new ArrayList<>(); 
	for (int i = 0; i < 30; i++) {
		int num = random.nextInt(10) + 1;
        numeros.add(num);	
        } // Fin del for
	
	// Ordenar la lista
	Collections.sort(numeros); 
	
	// Mostrar por pantalla la lista ordenada
	System.out.println("Lista ordenada: " + numeros);
    
} // Fin del main

} // Fin de la clase Ejercicio03
