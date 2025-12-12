package boletin01_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	        int[] numeros = new int[12];

	            numeros[0] = 39;
	            numeros[1] = -2;
	            numeros[4] = 0;
	            numeros[6] = 14;
	            numeros[8] = 5;
	            numeros[9] = 120;
	        

	        // Mostrar en orden inverso
	        System.out.println(Arrays.toString(numeros));
	      
	        // Cerrar 
	        sc.close();
	    }
	}