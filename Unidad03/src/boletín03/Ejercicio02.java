package boletín03;

import java.util.Scanner;

public class Ejercicio02 {

	//
	public static void main(String[] args) {
		/**
		 * Necesitamos crear un programa para almacenar las notas de 4 alumnos 
		 * (llamados “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario 
		 * introducirá las notas por teclado y luego el programa mostrará la 
		 * tabla con las notas. A continuación, mostrará la nota mínima, máxima 
		 * y media de cada alumno.
		 */
		
		// Crear Scanner
		Scanner reader = new Scanner(System.in); 
		
		//
		final int NUM_ALUMNO = 4;
		final int 	NUM_ASIGNATURAS = 5; 
		
		// Array
		double[][] notas = new double [NUM_ALUMNO][NUM_ASIGNATURAS];
		
		
			rellenarNotas(teclado,notas); 
			
			
			
			mostrarResumenPorAlumno(notas);
		
		}
		// Muestra la tabla de notas con los alumos en filas y asignaturas 
	private static void rellenarNotas(Scanner reader, double [][] notas) {
		for (int indiceAlumno=0; indiceAlumno < NUM_ALUMNO; indiceAlumno++)
			System.out.println("Introduce las notas del alumno " + indiceAlumno);
		
		for (int indiceAsignatura=0; indiceAsignatura < );
	}

}
