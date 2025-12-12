package boletin01_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		// Crear Scanner 
		Scanner sc = new Scanner(System.in);

		// Almacenar las  variables
		int suma = 0;
		int numeros = 0;
		
		// Crear tabla donde almacemos los 10 números introducidos por el usuario, aplicanto arrays
		int tabla[]  = new int[10];

		// Leer y almacenar los 10 números
		for (int i = 0; i < tabla.length; i++) {
			System.out.println("Introduce un número: ");
			numeros = sc.nextInt();

			tabla[i] = numeros;
			
		// Almacenar la suma de los 10 números introducidos
			suma += numeros;
		}
		
		// Crear el arrays
		Arrays.sort(tabla);

		// Mostrar en pantalla la suma de los numeros introducidos, mostrar el número más grande y mostrar el número menor introducidos
		System.out.println("La suma de todos los numeros es: " + suma);
		System.out.println("El número más pequeño es: " + tabla[0]);
		System.out.println("El número más grande es: " + tabla[9]);

		// Cerrar Scanner
		sc.close();

	}
}
