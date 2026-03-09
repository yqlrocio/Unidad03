package examenPrueba;

import java.util.Scanner;

/**
 * Aplicación que analiza si un mensaje oculto puede encontrarse dentro de un texto
 * como subsecuencia de caracteres.
 */

public class ejemplo1 {

    //Carácter espacio que se elimina durante la normalización.
    private static final char SPACE = ' ';

    // Mensaje mostrado cuando la entrada no es válida tras normalizar.
    private static final String INVALID_INPUT_MESSAGE =
            "(Entrada inválida tras normalizar: texto vacío, mensaje vacío o mensaje más largo que el texto.)";

    public static void main(String[] args) { // He metido lo que en clase hice como run() en el main; en realidad da un poco igual a estos niveles y no os quiero confundir mucho
        
    	Scanner scanner = new Scanner(System.in);

        String originalText = readLine(scanner, "Introduce el texto:");
        String originalMessage = readLine(scanner, "Introduce el mensaje a buscar:");

        analyzeAndPrint(originalText, originalMessage); // También he metido un print en la función de analizar, en lugar de hacerlo aparte en el main como hicimos ayer

        scanner.close();
    }

    /**
     * Normaliza los datos, valida la entrada, busca las apariciones
     * y muestra los resultados por pantalla.
     *
     * @param rawText texto original introducido por el usuario
     * @param rawMessage mensaje original introducido por el usuario
     */
    private static void analyzeAndPrint(String rawText, String rawMessage) {
        String normalizedText = normalizeText(rawText);
        String normalizedMessage = normalizeText(rawMessage);

        if (!isValidInput(normalizedText, normalizedMessage)) {
            printAnalysisResult(rawMessage, new int[0], 0.0, true);
            return;
        }

        char[] textCharacters = normalizedText.toCharArray();
        char[] messageCharacters = normalizedMessage.toCharArray();

        int[] startPositions = findMessageStartPositions(textCharacters, messageCharacters);
        int occurrenceCount = startPositions.length;
        double usagePercentage = calculateUsagePercentage(
                textCharacters.length,
                messageCharacters.length,
                occurrenceCount
        );

        printAnalysisResult(rawMessage, startPositions, usagePercentage, false);
    } // Esta función, para que estuviera de matrícula de honor sería conveniente dividirla en 3 funciones más pequeñas, intentando seguir siempre Clean Code

    /**
     * Lee una línea completa de texto desde teclado mostrando previamente un mensaje.
     *
     * @param scanner objeto Scanner ya inicializado para leer desde entrada estándar
     * @param prompt mensaje que se muestra antes de leer la entrada
     * @return la línea introducida por el usuario
     */
    private static String readLine(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    /**
     * Comprueba si la entrada es válida después de haber sido normalizada.
     *
     * La entrada será válida si:
     * el texto no está vacío,
     * el mensaje no está vacío,
     * la longitud del mensaje no supera la del texto.
     * 
     *
     * @param normalizedText texto ya normalizado
     * @param normalizedMessage mensaje ya normalizado
     * @return {@code true} si la entrada es válida; {@code false} en caso contrario
     */
    private static boolean isValidInput(String normalizedText, String normalizedMessage) {
        return normalizedText.length() > 0
                && normalizedMessage.length() > 0
                && normalizedMessage.length() <= normalizedText.length();
    }

    /**
     * Normaliza un texto convirtiéndolo a minúsculas y eliminando todos los espacios.
     *
     * Si la entrada es null o vacía, devuelve una cadena vacía.
     *
     * @param text texto original
     * @return texto normalizado sin espacios y en minúsculas
     */
    private static String normalizeText(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        String lowercaseText = text.toLowerCase();
        char[] cleanedCharacters = new char[lowercaseText.length()];
        int validLength = 0;

        for (int i = 0; i < lowercaseText.length(); i++) {
            char currentCharacter = lowercaseText.charAt(i);

            if (currentCharacter != SPACE) {
                cleanedCharacters[validLength] = currentCharacter;
                validLength++;
            }
        }

        return new String(cleanedCharacters, 0, validLength);
    }

    /**
     * Busca todas las posiciones del texto desde las que puede formarse el mensaje.
     *
     * @param textCharacters caracteres del texto normalizado
     * @param messageCharacters caracteres del mensaje normalizado
     * @return array con las posiciones iniciales válidas
     */
    private static int[] findMessageStartPositions(char[] textCharacters, char[] messageCharacters) {
        int[] temporaryPositions = new int[textCharacters.length];
        int validPositionCount = 0;

        for (int i = 0; i < textCharacters.length; i++) {
            if (isPotentialStart(textCharacters[i], messageCharacters[0])
                    && canBuildMessageFrom(textCharacters, messageCharacters, i)) {
                temporaryPositions[validPositionCount] = i;
                validPositionCount++;
            }
        }

        return copyArrayWithExactSize(temporaryPositions, validPositionCount);
    }

    /**
     * Indica si un carácter del texto puede ser un inicio potencial del mensaje.
     *
     * @param textCharacter carácter actual del texto
     * @param firstMessageCharacter primer carácter del mensaje
     * @return {@code true} si ambos caracteres coinciden; {@code false} en caso contrario
     */
    private static boolean isPotentialStart(char textCharacter, char firstMessageCharacter) {
        return textCharacter == firstMessageCharacter;
    }

    /**
     * Comprueba si el mensaje completo puede construirse como subsecuencia del texto
     * a partir de una posición concreta.
     *
     * @param textCharacters caracteres del texto
     * @param messageCharacters caracteres del mensaje
     * @param startIndex posición desde la que comienza la comprobación
     * @return true si el mensaje puede formarse; false en caso contrario
     */
    private static boolean canBuildMessageFrom(char[] textCharacters, char[] messageCharacters, int startIndex) {
        int messageIndex = 0;

        for (int textIndex = startIndex;
             textIndex < textCharacters.length && messageIndex < messageCharacters.length;
             textIndex++) {

            if (textCharacters[textIndex] == messageCharacters[messageIndex]) {
                messageIndex++;
            }
        }

        return messageIndex == messageCharacters.length;
    }

    /**
     * Crea una copia de un array de enteros con el tamaño exacto indicado.
     *
     * @param sourceArray array original
     * @param newSize tamaño que tendrá el nuevo array
     * @return nuevo array con los primeros newSize elementos del original
     */
    private static int[] copyArrayWithExactSize(int[] sourceArray, int newSize) {
        int[] resizedArray = new int[newSize];

        for (int i = 0; i < newSize; i++) {
            resizedArray[i] = sourceArray[i];
        }

        return resizedArray;
    }

    /**
     * Calcula el porcentaje teórico de uso del texto.
     *
     * Este porcentaje se obtiene multiplicando:
     * apariciones * longitud del mensaje
     * y dividiéndolo entre la longitud total del texto.
     *
     * No tiene en cuenta posibles solapamientos reales entre apariciones, que es en lo que quedamos ayer en clase, creo
     * Aún así no me convence mucho la implementación de esta funciṕon porque sigo creyendo que podría salir más del 100% de uso del texto y no tiene sentido.
     *
     * @param totalTextLength longitud total del texto normalizado
     * @param messageLength longitud del mensaje normalizado
     * @param occurrenceCount número de apariciones encontradas
     * @return porcentaje de uso del texto
     */
    private static double calculateUsagePercentage(int totalTextLength, int messageLength, int occurrenceCount) {
        if (totalTextLength <= 0 || messageLength <= 0 || occurrenceCount <= 0) {
            return 0.0;
        }

        int usedCharacters = messageLength * occurrenceCount;
        return (usedCharacters * 100.0) / totalTextLength;
    }

    /**
     * Muestra por pantalla los resultados del análisis.
     *
     * @param originalMessage mensaje original introducido por el usuario
     * @param startPositions posiciones iniciales en las que puede formarse el mensaje
     * @param usagePercentage porcentaje de uso calculado
     * @param invalidInput indica si la entrada era inválida tras la normalización
     */
    private static void printAnalysisResult(String originalMessage,
                                            int[] startPositions,
                                            double usagePercentage,
                                            boolean invalidInput) {

        System.out.println();
        System.out.println("Mensaje buscado: \"" + originalMessage + "\"");

        if (invalidInput) {
            printInvalidResult();
            return;
        }

        System.out.println("Apariciones encontradas: " + startPositions.length);
        System.out.print("Posiciones iniciales: ");
        printIntegerArray(startPositions);
        System.out.printf("Porcentaje de uso del texto: %.2f%%%n", usagePercentage);
    }

    /**
     * Muestra un resultado vacío cuando la entrada no es válida.
     */
    private static void printInvalidResult() {
        System.out.println("Apariciones encontradas: 0");
        System.out.println("Posiciones iniciales: []");
        System.out.printf("Porcentaje de uso del texto: %.2f%%%n", 0.0);
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    /**
     * Imprime un array de enteros con formato de lista.
     *
     * Ejemplo:
     * [0, 4, 7]
     *
     * @param array array de enteros a mostrar
     */
    private static void printIntegerArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}