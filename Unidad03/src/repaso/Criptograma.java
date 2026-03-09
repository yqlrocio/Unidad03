package repaso;

import java.util.Random;
import java.util.Scanner;

public class Criptograma {

	public static Random rnd = new Random();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		char[][] abecedario = new char[3][9];

		String[] frases = { "las guerras seguiran", "aprende a vivir", "cada dia sabemos", "el dinero no",
				"la verdadera sabiduria" };

		char letra = 'a';


		for (int x = 0; x < abecedario.length; x++) {
			for (int y = 0; y < abecedario[x].length; y++) {
				abecedario[x][y] = letra;
				letra++;
				System.out.print(abecedario[x][y] + "\t");
			}
			System.out.println();
		}

		char[][] abecedarioDesordenado = desordenaAbecedario(abecedario);

		String fraseElegida = eligeFrase(frases);

		String fraseCod = codificaFrase(abecedarioDesordenado, fraseElegida);

		System.out.println(fraseCod);

		sc.close();

	}

	public static char[][] desordenaAbecedario(char[][] abecedarioOrdenado) {

		char[][] abecedarioDesordenado = new char[3][9];

		int fila;
		int columna;
		boolean letraUsada;

		for (int x = 0; x < abecedarioOrdenado.length; x++) {
			for (int y = 0; y < abecedarioOrdenado[x].length; y++) {

				do {
					letraUsada = false;
					fila = rnd.nextInt(0, abecedarioOrdenado.length);
					columna = rnd.nextInt(0, abecedarioOrdenado[0].length);

					char letra = abecedarioOrdenado[fila][columna];

					for (int i = 0; i < abecedarioOrdenado.length; i++) {
						for (int j = 0; j < abecedarioOrdenado[x].length; j++) {
							if (abecedarioDesordenado[i][j] == letra) {
								letraUsada = true;
							}
						}
					}

					if (!letraUsada) {
						abecedarioDesordenado[x][y] = abecedarioOrdenado[fila][columna];
					}

				} while (abecedarioDesordenado[x][y] == 0);

			}
		}

		return abecedarioDesordenado;

	}

	public static String eligeFrase(String[] todasLasFrases) {

		int numFrase = rnd.nextInt(0, todasLasFrases.length);

		String fraseElegida = todasLasFrases[numFrase];

		return fraseElegida;

	}

	public static String codificaFrase(char[][] abcDesordenado, String frase) {
		String fraseCod = "";

		for (int i = 0; i < frase.length(); i++) {
			char letraActual = frase.charAt(i);
			if (letraActual == ' ') {
				fraseCod += "  ";
			} else {
				for (int x = 0; x < abcDesordenado.length; x++) {
					for (int y = 0; y < abcDesordenado[0].length; y++) {
						if (letraActual == abcDesordenado[x][y]) {
							fraseCod += x;
							fraseCod += y;
							fraseCod += " ";
						}
					}
				}
			}
		}

		return fraseCod;
	}

	public static boolean compruebaCodigo(char[][] abcDes, String fraseCod) {

		boolean seModifica = false;
		
		System.out.println("Introduce caracter: ");
		char caracter = sc.nextLine().charAt(0);
		
		for (int i = 0; i < abcDes.length; i++) {
			
		}
		
		return seModifica;
		
	}

}