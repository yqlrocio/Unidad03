package boletin04_funciones;

import java.util.Random;

public class Ejercicio02 {

	public static void main(String[] args) {
		
	/*
	 *Diseñar la función: int maximo(int t[]),
	 * que devuelva el máximo valor contenido 
	 * en la tabla t. 
	 */
	
	// Creación del array
			int[] array = new int[8];

			// Se imprime el máximo valor de la tabla
			System.out.println("El máximo valor contenido en la tabla es " + devuelveMaximo(array));

		}

		/**
		 * Función que recorre el array, comprueba el número máximo y devuelve el máximo
		 * valor contenido en el array
		 * 
		 * @param array
		 * @return valor máximo
		 */

		public static int devuelveMaximo(int[] array) {

			Random rnd = new Random();

			int max = Integer.MIN_VALUE;

			int maximo = 0;

			for (int i = 0; i < array.length; i++) {
				array[i] = rnd.nextInt(1, 100);
				if (array[i] > max) {
					maximo = array[i];
				}
			}

			return maximo;

		}

	}