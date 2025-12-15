package boletin04_funciones;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		/*
		 * Realiza una función que reciba como
		 * parámetro una tabla de enteros y 
		 * devuelva la suma de todos los valores 
		 * almacenados en la tabla. Prueba el 
		 * comportamiento de la función en un 
		 * método main.
		 */

		// Definir tabla de entero
		int [] numeros = {}; 
		
		// Variable para almacenar la suma
		int sumaTotal = sumarTabla(numeros);
		
		System.out.println("Suma total= " + sumaTotal);
	}
	
	public static int sumarTabla(int [] numeros) {
 		if (numeros == null) {
 			throw new IllegalArgumentException("ERROR: la tabla no puede ser nula");
 						
 		}

 		int sumaTotal = 0; 
 		for (int indiceActual = 0; indiceActual < numeros.length ; indiceActual++) {
 		sumaTotal += numeros[indiceActual]; 
 		}
 		
 		return sumaTotal; 
	}
	
}
