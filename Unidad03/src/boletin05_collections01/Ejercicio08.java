package boletin05_collections01;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		

		/*
		 *Implementa el control de acceso al área restringida de un 
		 *programa. Los nombres de usuario con sus correspondientes 
		 *contraseñas deben estar almacenados en una estructura de la 
		 *clase HashMap. El programa mostrará un menú con dos opciones:
		 *
		 * 1. Registro. Debe pedir un nombre de usuario y una contraseña. 
		 *	  A continuación, se almacenarán en el mapa.
		 *2. Login. Debe pedir un nombre de usuario y una contraseña. 
		 *	 Si el usuario introduce los datos correctamente, el programa 
		 *	 dirá “Ha accedido al área restringida”. El usuario tendrá un 
		 *	 máximo de 3 oportunidades. Si se agotan las oportunidades el 
		 *	 programa dirá “Lo siento, no tiene acceso al área restringida”.
		 *0. Salir. Termina el programa.

		 */
		
		/**
		 * Debe:
		 * - Registrar el nombre y la contraseña del usuario
		 * - Login pedir nombre y contraseña 
		 * - Salir del programa
		 * 
		 * Necesitamos: 
		 * - HashMap -> almacenará usuario y contraseña 
		 * - Scanner -> leer 
		 * - Menú -> switch
		 * - Contador -> 3 intentos como máximo
		 */
		
	Scanner scanner = new Scanner(System.in);
	
	 HashMap<String, String> usuarios = new HashMap<>();
	
	    int opcion;
	
	    do {
	        System.out.println("\n--- MENÚ ---");
	        System.out.println("1. Registro");
	        System.out.println("2. Login");
	        System.out.println("3. Salir");
	        System.out.print("Elige una opción: ");
	        opcion = scanner.nextInt();
	        scanner.nextLine(); // Mostrar la opción elegida por el usuario
	
	        switch (opcion) {
	
	            case 1: // Registro
	                System.out.print("Introduce nombre de usuario: ");
	                String usuario = scanner.nextLine();
	
	                System.out.print("Introduce contraseña: ");
	                String contraseña = scanner.nextLine();
	
	                usuarios.put(usuario, contraseña);
	                System.out.println("Usuario registrado correctamente.");
	                break;
	
	            case 2: // Login
	                int intentos = 3;
	                boolean acceso = false;
	
	                while (intentos > 0 && !acceso) {
	
	                    System.out.print("Usuario: ");
	                    String user = scanner.nextLine();
	
	                    System.out.print("Contraseña: ");
	                    String pass = scanner.nextLine();
	
	                    if (usuarios.containsKey(user) && usuarios.get(user).equals(pass)) {
	                        System.out.println("Ha accedido al área restringida");
	                        acceso = true;
	                    } else {
	                        intentos--;
	                        if (intentos > 0) {
	                            System.out.println("Datos incorrectos. Intentos restantes: " + intentos);
	                        }
	                    }
	                }
	
	                if (!acceso) {
	                    System.out.println("Lo siento, no tiene acceso al área restringida");
	                }
	
	                break;
	
	            case 3:
	                System.out.println("Programa finalizado.");
	                break;
	
	            default:
	                System.out.println("Opción no válida.");
	        }
	
	    } while (opcion != 3);
	
	    scanner.close();

	} // Fin del main

} // Fin de la clase Ejercicio08
