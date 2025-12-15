package boletin04_funciones;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		/*
		 *Diseñar la función: int maximo(int t[]),
		 * que devuelva el máximo valor contenido 
		 * en la tabla t. 
		 */
		
		// 
		int[] numeros = {1, 4, 9, -3, 9, 1, -9}; 
		
		int maximo = maximo (numeros); 
		
		System.out.println("Máximo = " + maximo);
	}
	
	public static int maximo (int numeros []) {
		if (numeros == null || numeros.length == 0){
			throw new IllegalArgumentException ("La tabla no puede ser nulo");
	}
	int maximoActual = numeros[0]; 
	
	for (int i = 0; i < numeros.length; i++) {
		if(numeros[i] > maximoActual) { 
		maximoActual = numeros [i]; 
		}
		}
	return maximoActual; 
	
	}
}
