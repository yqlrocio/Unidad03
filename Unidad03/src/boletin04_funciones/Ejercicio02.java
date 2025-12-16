package boletin04_funciones;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		/*
		 *Diseñar la función: int maximo(int t[]),
		 * que devuelva el máximo valor contenido 
		 * en la tabla t. 
		 */
		
		// 
		int [][] matriz = {
				{1,2,3},
				{4,5,6}
		}; 
		
		int [][] transpuesta = transponer(matriz); 
		
		System.out.println("Original: ");
		imprimirMatriz(matriz); 
		
		System.out.println("Transpuesta: ");
		imprimirMatriz(transpuesta);
		
		}
	
		public static int [][] transponer(int [][] matriz) {
		if (matriz == null) {
			throw new IllegalArgumentException("La matriz no puede ser null ");
		}
		if (matriz.length == null ) {
			throw new IllegalArgumentException ("La ");
		}
		
		int filas = matriz.length;
		int columas = matriz[0].length;
		
		for (int IindiceFila=0, indiceFila < fila; indiceFila++) { 
			if(matriz[indiceFila] == null || matriz[indiceFila].length != columnas) {
				throw new IllegalArgumentException ("Todas las filas deben tener el mismo número")			
			}
		}
		int [][] resultado = new int [columnas][filas]; 
		
		for (int indice = 0; fila < filas; fila++) {
			for ()
		}
	}
}