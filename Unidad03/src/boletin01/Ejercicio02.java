package boletin01;

import java.util.Scanner;

public class Ejercicio02 {




	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        double[] numeros = new double[5];

	        // Primer bucle: pedir y almacenar
	        for (int i = 0; i < numeros.length; i++) {
	            System.out.print("Introduce un número decimal (" + (i + 1) + "/5): ");
	            while (!sc.hasNextDouble()) {
	                System.out.print("ERROR: introduce un número decimal válido: ");
	                sc.next(); // limpiar la entrada incorrecta
	            }
	            numeros[i] = sc.nextDouble();
	        }

	        // Segundo bucle: mostrar los números
	        System.out.println("\nNúmeros introducidos:");
	        for (int i = 0; i < numeros.length; i++) {
	            System.out.println(numeros[i]);
	        }

	        sc.close();
	    }
	}

