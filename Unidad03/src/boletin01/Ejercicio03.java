package boletin01;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);
		        int[] numeros = new int[10];

		        // Leer y almacenar los 10 números
		        for (int i = 0; i < numeros.length; i++) {
		            System.out.print("Introduce un número (" + (i + 1) + "/10): ");
		            numeros[i] = sc.nextInt();
		        }

		        // Mostrar en orden inverso
		        System.out.println("\nNúmeros en orden inverso:");
		        for (int i = numeros.length - 1; i >= 0; i--) {
		            System.out.println(numeros[i]);
		        }

		        sc.close();
		    }
		}
