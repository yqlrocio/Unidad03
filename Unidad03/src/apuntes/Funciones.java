package apuntes;

import java.util.Arrays;

public class Funciones {		
		    
		    // 1. Función con int - Calcula el factorial de un número
    static public int calcularFactorial(int numero) {
        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    // 2. Función con array - Encuentra el número mayor en un array
    static public int encontrarMayor(int[] numeros) {
        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        return mayor;
    }
    
    // 3. Función con String - Cuenta las vocales en un texto
    static public int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase(); // Convertir a minúsculas
        
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contador++;
            }
        }
        return contador;
    }
    
    // 4. Función adicional con array - Suma todos los elementos
    public int sumarArray(int[] numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }
    
    // 5. Función adicional con String - Invierte un texto
    public String invertirTexto(String texto) {
        String invertido = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            invertido += texto.charAt(i);
        }
        return invertido;
    }
   
}