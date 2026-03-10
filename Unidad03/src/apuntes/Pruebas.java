package apuntes;

import java.util.Random;

public class Pruebas {

	public static void main(String[] args) {
		
		Random rnd = new Random();

		// CREAR ARRAY BIDIMENSIONAL
		int[][] numeros = new int[2][4];
		
		// RECORRE E IMPRIMIR ARRAY
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				numeros[i][j] = rnd.nextInt(1,11);
				System.out.print(numeros[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
