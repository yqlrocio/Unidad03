package repaso;

import java.util.Scanner;

public class MensajesGrabados {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int indice;
		String mensaje;
		String[] mensajes = new String[8];

		mensajes[0] = "LA NIEBLA CUBRE EL PUENTE";
		mensajes[1] = "NO MIRES DETRÁS DE LA PUERTA";
		mensajes[2] = "EL RELOJ SUENA A MEDIANOCHE";
		mensajes[3] = "LAS SOMBRAS SABEN TU NOMBRE";
		mensajes[4] = "TODO MENSAJE DEJA UNA HUELLA";
		mensajes[5] = "EL ECO REPITE LA VERDAD";
		mensajes[6] = "ALGUIEN ESCONDE ALGO AQUÍ";
		mensajes[7] = "NUNCA APAGUES LA RADIO";

		mostrarMensajes(mensajes);

		System.out.println("Introduzca un índice para comprobar si existe en el array: ");
		indice = sc.nextInt();
		System.out.println("El índice aparece en el array: " + esIndiceValido(mensajes, indice));

	}

	private static void mostrarMensajes(String[] mensajes) {
		for (int i = 0; i < mensajes.length; i++) {
			System.out.println(i + ". " + mensajes[i]);
		}
	}

	private static boolean esIndiceValido(String[] mensajes, int indice) {
		boolean valido = true;
		if (indice > mensajes.length || indice < mensajes.length) {
			valido = false;
		}
		return valido;
	}

	private static int contarLetra(String mensaje, char letra) {
		int contador = 0;
		char[] letrasMensaje = mensaje.toCharArray();
		for (int i = 0; i < mensaje.length(); i++) {
			if (letrasMensaje[i] == letra) {
				contador++;
			}
		}
		return contador;
	}

	private static String quitarEspacios(String mensaje) {
		return mensaje.trim().replaceAll("\\s+", "");
	}

	private static String extraerMensajeOculto(String mensaje) {
		String mensajePar;
		char[] letrasMensaje = mensaje.toCharArray();
		for (int i = 0; i < letrasMensaje.length; i++) {
			if (i % 2 == 0) {
				System.out.println(mensaje.charAt(i));
			}
		}
		return mensajePar = new String(mensaje);
	}

	private static int buscarMensajesConPalabra(String[] mensajes, String palabra) {
		int contador = 0;
		String[] todasLasPalabras = new String[40];
		String mensaje;
		for (int i = 0; i < mensajes.length; i++) {
			mensaje = mensajes[i];
			todasLasPalabras = mensaje.split(" ");
		}
		for (int i = 0; i < todasLasPalabras.length; i++) {
			if (todasLasPalabras[i].equals(palabra)) {
				contador++;
			}
		}
		return contador;
	}

	private static boolean marcarAlterado(String[] mensajes, int indice) {

	}

}
