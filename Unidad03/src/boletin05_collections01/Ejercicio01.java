package boletin05_collections01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		//--------------------------------------------------------------------------------------------------------------
		/*
		 * Crear una lista de números enteros positivos introducidos por consola hasta que se introduzca uno negativo. 
		 * A continuación, recorrer la lista y mostrar por pantalla los índices de los elementos de valor par.
		*/ 
		//--------------------------------------------------------------------------------------------------------------

		// Crear Scanner 
		Scanner reader = new Scanner(System.in);
		
		ArrayList<Integer> lista = new ArrayList<>();

        int numero;

        // Leer números hasta que se introduzca uno negativo
        System.out.println("Introduce números enteros positivos (negativo para terminar):");

        do {
            numero = reader.nextInt();
            if (numero >= 0) {
                lista.add(numero);
            }
        } while (numero >= 0);

        // Recorrer la lista y mostrar los índices de los números pares
        System.out.println("Índices de los números pares:");

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                System.out.println("Índice: " + i);
            }
        }

        reader.close();
    }
}