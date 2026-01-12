package ejercicios_parte1;

import java.util.Scanner;

public class PrincipalPunto {

	public static void main(String[] args) {
		
		// APARTADO A - CLASES SIMPLES CON ATRIBUTOS ------------------------------------
		
		/*
		 * EJERCICIO A1 - PUNTO: --------------------------------------------------------
		 * Crea un programa con una clase llamada Punto que representará un punto de dos 
		 * dimensiones en un plano. Solo contendrá dos atributos enteros llamados x e y 
		 * (coordenadas).
		 * En el main de la clase principal instancia 3 objetos Punto con las coordenadas 
		 * (5,0), (10,10) y (-3,7). Muestra por pantalla sus coordenadas (utiliza un 
		 * println para cada punto). Modifica todas las coordenadas (prueba distintos 
		 * peradores como = + - += *=...) y vuelve a imprimirlas por pantalla.
		 */

	// Instanciamos los puntos
		Punto punto1 = new Punto(5, 0);
		Punto punto2 = new Punto(10, 10);
		Punto punto3 = new Punto(-3, 7);

	// Mostramos las coordenadas originales
		System.out.println("Coordenadas originales:");
		punto1.mostrar();
		punto2.mostrar();
		punto3.mostrar();

	// Modificamos las coordenadas usando distintos operadores
		punto1.x += 2; // suma
		punto1.y -= 1; // resta

		punto2.x *= 2; // multiplicación
		punto2.y = punto2.y + 5; // suma con =

		punto3.x = -punto3.x; // cambio de signo
		punto3.y += 3;

	// Mostramos las coordenadas modificadas
		System.out.println("\nCoordenadas modificadas:");
		punto1.mostrar();
		punto2.mostrar();
		punto3.mostrar();
	
		/*
		 * APARTADO A2 - PERSONA: -------------------------------------------------------
		 * Crea un programa con una clase llamada Persona que representará los datos 
		 * principales de una persona: dni, nombre, apellidos y edad.
		 * En el main de la clase principal instancia dos objetos de la clase Persona. 
		 * Luego, pide por teclado los datos de ambas personas (guárdalos en los objetos). 
		 * Por último, imprime dos mensajes por pantalla (uno por objeto) con un mensaje 
		 * del estilo “Azucena Luján García con DNI … es / no es mayor de edad”.
		 */
	
		Scanner sc = new Scanner(System.in);

	// Instanciamos dos personas
		Persona persona1 = new Persona();
		Persona persona2 = new Persona();

	// Pedimos los datos de la primera persona
		 System.out.println("Introduce los datos de la primera persona:");
		 
		 System.out.print("DNI: ");
		 persona1.dni = sc.nextLine();
		        
		 System.out.print("Nombre: ");
		 persona1.nombre = sc.nextLine();
		       
		 System.out.print("Apellidos: ");
		 persona1.apellidos = sc.nextLine();
		        
		 System.out.print("Edad: ");
		 persona1.edad = sc.nextDouble();
		        
		 sc.nextLine(); // limpiar buffer

	// Pedimos los datos de la segunda persona
		 System.out.println("\nIntroduce los datos de la segunda persona:");
		 
		 System.out.print("DNI: ");
		 persona2.dni = sc.nextLine();
		        
		 System.out.print("Nombre: ");
		 persona2.nombre = sc.nextLine();
		        
		 System.out.print("Apellidos: ");
		 persona2.apellidos = sc.nextLine();
		        
		 System.out.print("Edad: ");
		 persona2.edad = sc.nextDouble();

	// Mostramos los mensajes
		  System.out.println();
		       
		  System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni +
		  (persona1.esMayorDeEdad() ? " es mayor de edad." : " no es mayor de edad."));

		  System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.dni +
		  (persona2.esMayorDeEdad() ? " es mayor de edad." : " no es mayor de edad."));

	sc.close();
	
	/*
	 * APARTADO A3 - Rectángulo: -------------------------------------------------------
	 * Crea un programa con una clase llamada Rectangulo que representará un rectángulo 
	 * mediante dos coordenadas (x1,y1) y (x2,y2) en un plano, por lo que la clase 
	 * deberá tener cuatro atributos enteros: x1, y1, x2, y2.
	 * En el main de la clase principal instancia 2 objetos Rectangulo en (0,0)(5,5) y 
	 * (7,9)(2,3). Muestra por pantalla sus coordenadas, perímetros (suma de lados) y 
	 * áreas (ancho x alto). Modifica todas las coordenadas como consideres y vuelve a 
	 * imprimir coordenadas, perímetros y áreas.
	 */

	        // Instanciamos los rectángulos
	        Rectangulo r1 = new Rectangulo(0, 0, 5, 5);
	        Rectangulo r2 = new Rectangulo(7, 9, 2, 3);

	        // Mostramos datos iniciales
	        System.out.println("Datos iniciales:");
	        r1.mostrar();
	        r2.mostrar();

	        // Modificamos las coordenadas
	        r1.x1 += 2;
	        r1.y1 += 1;
	        r1.x2 *= 2;
	        r1.y2 *= 2;

	        r2.x1 -= 1;
	        r2.y1 += 3;
	        r2.x2 += 4;
	        r2.y2 -= 2;

	        // Mostramos datos modificados
	        System.out.println("Datos modificados:");
	        r1.mostrar();
	        r2.mostrar();
	    }
	}
	
	
}

}
