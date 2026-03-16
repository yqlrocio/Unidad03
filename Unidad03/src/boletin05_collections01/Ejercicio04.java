package boletin05_collections01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		/*
		 * Implementa una aplicación donde se insertan 20 números enteros 
		 * aleatorios distintos, menores que 100, en una colección. Hay 
		 * que asegurarse de que se guardan 20. Deben guardarse ordenados 
		 * a medida que se vayan generando, y se mostrará la colección 
		 * resultante por pantalla.
		 */
		
		/**
		 * Necesitamos: 
		 * - Tamaño de la lista -> 20 valores aleatorios 
		 * - 20 Valores aleatorios -> desde 1-100
		 * - Lista ordenada
		 * - Mostrar por pantalla
		 */ 
		
	// Creamos random 
	Random random = new Random (); 
	
	// Creamos un ArrayList con números comprendidos desde 0 al 10 con el tamaño aleatorio de la lista creado anteriormente
	ArrayList<Integer> numeros = new ArrayList<>(); 
	for (int i = 0; i < 20; i++) {
		int num = random.nextInt(100) + 1;
        numeros.add(num);	
        } // Fin del for
	
	// Ordenar la lista
	Collections.sort(numeros); 
	
	// Mostrar por pantalla la lista ordenada
	System.out.println("Lista ordenada: " + numeros);
    
} // Fin del main

} // Fin de la clase Ejercicio04
