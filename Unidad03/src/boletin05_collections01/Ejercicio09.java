package boletin05_collections01;

import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio09 {

	public static void main(String[] args) {
		
		/*
		 * Implementa una aplicación donde ir registrando el número de veces 
		 * que ha salido cada número del euromillón. 
		 * 
		 * Para ello tendrás que usar dos colecciones, una para los números 
		 * y otra para las estrellas. 
		 * 
		 * Al usuario se le debe pedir que introduzca primero los 5 números 
		 * y a continuación las 2 estrellas del último sorteo. 
		 * 
		 * El programa comprobará si ya se encuentra el número correspondiente 
		 * en la colección, si no está, lo añadirá y le pondrá el valor 1. Si 
		 * ya está, incrementará en 1 su valor.
		 * 
		 * Las colecciones no pueden tener repetidos y deben estar ordenadas.
		 */
		
		/**
		 * Necesitamos: 
		 * 	- TreeMap -> números -> de longitud 5 entre valores comprendidos entre 1-50
		 * 	- TreeMap -> estrellas -> de longitud 2 entre valores comprendidos entre 1-12
		 * 	- equalsIgnoreCase -> no repetir numeros
		 * 	- Lista ordenada
		 */
		
		// Crear Scanner
		Scanner scanner = new Scanner(System.in); 
		
		// Usar TreeMap para guardar los número y cuántas veces han salido
		TreeMap<Integer, Integer> numeros = new TreeMap<>(); 
		TreeMap<Integer, Integer> estrellas = new TreeMap<>(); 

		// Pedir 5 números
		System.out.println("Introduce 5 números entre los valores del 1-50: ");
		for(int i = 0; i < 5; i++) {
			int num = scanner.nextInt(); 
			
			// Comprobar si el número ya está en el mapa
			// Si ya existe, sumamos 1 a su contador
			// Si no existe, lo añadimos con contador 1
			if (numeros.containsKey(num)) {
			    numeros.put(num, numeros.get(num) + 1);
			} else {
			    numeros.put(num, 1);
			} // fin del else
		} // fin del for
		
		
		 // Introducir 2 estrellas
        System.out.println("Introduce 2 estrellas entre los valores del 1-12: ");
        for (int i = 0; i < 2; i++) {
            int est = scanner.nextInt();

            if (estrellas.containsKey(est)) {
                estrellas.put(estrellas.get(est), estrellas.get(est) + 1);
            } else {
                estrellas.put(est, 1);
            }
        }


        // Mostrar resultados
        System.out.println("\nFrecuencia de números:");
        for (int n : numeros.keySet()) {
            System.out.println(n + " -> " + numeros.get(n) + " veces");
        }

        System.out.println("\nFrecuencia de estrellas:");
        for (int e : estrellas.keySet()) {
            System.out.println(e + " -> " + estrellas.get(e) + " veces");
        }
        
        scanner.close();
    }
}

