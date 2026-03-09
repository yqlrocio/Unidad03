package boletin01_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		
  Scanner sc = new Scanner(System.in);
    int[] num = new int[12];

    num[0] = 39;
    num[1] = -2;
    num[4] = 0;
    num[6] = 14;
    num[8] = 5;
    num[9] = 120;
    

    // Mostrar en orden inverso
    System.out.println(Arrays.toString(num));
  
    // Cerrar 
        sc.close();
    }
}