package boletin05_collections01;

import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio07 {

	public static void main(String[] args) {

		/*
		 *Crea un mini-diccionario español-inglés que contenga, al menos, 
		 *20 palabras (con su correspondiente traducción). Utiliza un 
		 *objeto de la clase TreeMap para almacenar las parejas de 
		 *palabras. El programa mostrará un menú con dos opciones: 
		 *	- Inserta palabra. Debe solicitar una palabra en español 
		 *	y su traducción al inglés.
		 *	- Busca palabra. Pregunta por una palabra en español y 
		 *	devuelve su traducción en inglés.
		 *	- Salir. Termina el programa.
		 */
		
		/**
		 * Necesitamos: 
		 * - TreeMap -> almacenará los valores en pareja (español-inglés)
		 * - bucle y condicional -> para el menú y las operaciones del usuario
		 */

	Scanner scanner = new Scanner(System.in);

    // Creamos el TreeMap para el diccionario: clave = español, valor = inglés
    TreeMap<String, String> diccionario = new TreeMap<>();

    // Inicializamos con al menos 20 palabras
    diccionario.put("casa", "house");
    diccionario.put("perro", "dog");
    diccionario.put("gato", "cat");
    diccionario.put("libro", "book");
    diccionario.put("mesa", "table");
    diccionario.put("silla", "chair");
    diccionario.put("agua", "water");
    diccionario.put("comida", "food");
    diccionario.put("escuela", "school");
    diccionario.put("maestro", "teacher");
    diccionario.put("coche", "car");
    diccionario.put("ciudad", "city");
    diccionario.put("amigo", "friend");
    diccionario.put("familia", "family");
    diccionario.put("tiempo", "time");
    diccionario.put("trabajo", "work");
    diccionario.put("ventana", "window");
    diccionario.put("puerta", "door");
    diccionario.put("playa", "beach");
    diccionario.put("montaña", "mountain");

    int opcion;

    do {
        // Mostrar menú
        System.out.println("\n--- MINI DICCIONARIO ESPAÑOL-INGLÉS ---");
        System.out.println("1. Insertar palabra");
        System.out.println("2. Buscar palabra");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                // Insertar palabra
                System.out.print("Introduce la palabra en español: ");
                String esp = scanner.nextLine().toLowerCase();
                System.out.print("Introduce la traducción al inglés: ");
                String eng = scanner.nextLine().toLowerCase();
                diccionario.put(esp, eng);
                System.out.println("Palabra añadida correctamente.");
                break;

            case 2:
                // Buscar palabra
                System.out.print("Introduce la palabra en español a buscar: ");
                String buscar = scanner.nextLine().toLowerCase();
                if (diccionario.containsKey(buscar)) {
                    System.out.println("Traducción: " + diccionario.get(buscar));
                } else {
                    System.out.println("La palabra no se encuentra en el diccionario.");
                }
                break;

            case 3:
                System.out.println("¡Hasta luego!");
                break;

            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
        }

    } while (opcion != 3);

    scanner.close();
   
	} // Fin del main

} // Fin de la clase Ejercicio07
