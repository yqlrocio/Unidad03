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
    
    // Método main que prueba todas las funciones
    public static void main(String[] args) {
        funciones pf = new funciones();
        
        System.out.println("=== PRUEBA DE FUNCIONES ===\n");
        
        // Prueba 1: Función con int (factorial)
        System.out.println("--- FUNCIONES CON INT ---");
        int numero = 5;
        int factorial = pf.calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);
        
        // Prueba 2: Función con int (otro ejemplo)
        int numero2 = 7;
        System.out.println("El factorial de " + numero2 + " es: " + pf.calcularFactorial(numero2));
        System.out.println();
        
        // Prueba 3: Funciones con array
        System.out.println("--- FUNCIONES CON ARRAYS ---");
        int[] miArray = {15, 8, 23, 4, 42, 16};
        
        System.out.println("Array: " + Arrays.toString(miArray));
        
        int mayor = pf.encontrarMayor(miArray);
        System.out.println("El número mayor en el array es: " + mayor);
        
        int suma = pf.sumarArray(miArray);
        System.out.println("La suma de todos los elementos es: " + suma);
        System.out.println();
        
        // Prueba 4: Funciones con String
        System.out.println("--- FUNCIONES CON STRING ---");
        String texto = "Hola Mundo desde Java";
        
        System.out.println("Texto original: \"" + texto + "\"");
        
        int vocales = pf.contarVocales(texto);
        System.out.println("Número de vocales: " + vocales);
        
        String textoInvertido = pf.invertirTexto(texto);
        System.out.println("Texto invertido: \"" + textoInvertido + "\"");
        System.out.println();
        
        // Prueba 5: Combinando todo
        System.out.println("--- COMBINANDO TODO ---");
        String[] nombres = {"Ana", "Carlos", "Beatriz", "David"};
        System.out.println("Nombres: " + Arrays.toString(nombres));
        
        // Contar vocales de cada nombre
        for (String nombre : nombres) {
            int vocalesEnNombre = pf.contarVocales(nombre);
            System.out.println(nombre + " tiene " + vocalesEnNombre + " vocales");
        }
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}