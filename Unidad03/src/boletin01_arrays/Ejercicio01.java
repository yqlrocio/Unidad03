package boletin01_arrays;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		// Crear Scanner
		Scanner reader = new Scanner(System.in);
		
		// Crear número aleatorio
		Random rand = new Random(); 
		
		// Inicializar lista

		 int[] tabla = new int[10];

	     for (int i = 0; i < tabla.length; i++) {
		 tabla[i] = rand.nextInt(100) + 1; // valores entre 1 y 100
		  }

		 // Mostrar el contenido de la tabla
		 for (int num : tabla) {
		  System.out.print(num + " ");
		}
		 
		 // Cerrar Scanner 
		 reader.close(); 
		 
	}
}