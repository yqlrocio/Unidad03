package clean_code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CajaMagnifica {

	/**
	 * Sistema de Gestión de Ventas con Caja Registradora Permite registrar compras,
	 * aplicar descuentos y gestionar stock
	 */

	// ============= CONSTANTES DEL SISTEMA =============
	// Valores fijos que no cambian durante la ejecución
	private static final double IVA = 0.21; // 21% de IVA
	private static final double DESCUENTO_MAS_DE_100 = 0.10; // 10% descuento compras >100€
	private static final double DESCUENTO_POR_SOCIO = 0.05; // 5% descuento para socios
	private static final double UMBRAL_DESCUENTO = 100.0; // Límite para aplicar descuento

	// Configuración del stock
	private static final int TAMANO_STOCK = 200; // Tamaño del inventario
	private static final int STOCK_INICIAL = 10; // Unidades iniciales por producto

	// Límites para validación
	private static final int MAX_PRODUCTOS = 50; // Máximo productos por compra
	private static final int MAX_UNIDADES = 100; // Máximo unidades por producto
	private static final int MIN_PRODUCTOS = 1; // Mínimo productos por compra
	private static final int MIN_UNIDADES = 1; // Mínimo unidades por producto

	/**
	 * Método principal - Punto de entrada del programa
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 1. Inicializar el sistema
		int[] stock = inicializarStock(TAMANO_STOCK, STOCK_INICIAL);
		mostrarMensajeBienvenida();

		boolean continuarComprando = true;

		// 2. Bucle principal: atender múltiples clientes
		while (continuarComprando) {
			atenderCliente(scanner, stock);
			continuarComprando = preguntarOtraCompra(scanner);
		}

		// 3. Finalizar programa
		mostrarMensajeDespedida();
		scanner.close();
	}

	/**
	 * Atiende a un cliente completo: desde entrada de productos hasta ticket
	 */
	private static void atenderCliente(Scanner scanner, int[] stock) {
		// 1. Obtener información del cliente
		int cantidadProductos = pedirCantidadProductos(scanner);

		// 2. Crear arrays para almacenar los productos
		String[] nombres = new String[cantidadProductos];
		double[] precios = new double[cantidadProductos];
		int[] unidades = new int[cantidadProductos];

		// 3. Registrar cada producto
		double subtotal = registrarProductos(scanner, stock, nombres, precios, unidades);

		// 4. Preguntar si es socio
		boolean esSocio = esClienteSocio(scanner);

		// 5. Calcular todos los importes
		ResultadoCalculos calculos = calcularImportes(subtotal, esSocio);

		// 6. Mostrar el ticket de compra
		mostrarTicket(nombres, precios, unidades, subtotal, calculos);
	}

	// ============= CLASE PARA ORGANIZAR RESULTADOS =============

	/**
	 * Clase que contiene todos los resultados del cálculo Mejor que usar arrays
	 * porque es más claro
	 */
	private static class ResultadoCalculos {
		double descuentoVolumen; // Descuento por compra >100€
		double descuentoSocio; // Descuento adicional por socio
		double baseImponible; // Base sobre la que se calcula IVA
		double importeIVA; // Cantidad de IVA
		double totalPagar; // Total final a pagar
	}

	// ============= MÉTODOS DE INICIALIZACIÓN =============

	/**
	 * Prepara el inventario con stock inicial
	 */
	private static int[] inicializarStock(int tamano, int stockInicial) {
		int[] stock = new int[tamano];
		for (int i = 0; i < stock.length; i++) {
			stock[i] = stockInicial;
		}
		return stock;
	}

	/**
	 * Muestra mensaje de bienvenida al sistema
	 */
	private static void mostrarMensajeBienvenida() {
		System.out.println("=================================");
		System.out.println("   SISTEMA DE CAJA REGISTRADORA   ");
		System.out.println("=================================");
	}

	/**
	 * Muestra mensaje de despedida
	 */
	private static void mostrarMensajeDespedida() {
		System.out.println("\n=================================");
		System.out.println("  ¡Gracias por usar el sistema!  ");
		System.out.println("=================================");
	}

	// ============= MÉTODOS DE ENTRADA DE DATOS =============

	/**
	 * Pregunta cuántos productos va a comprar el cliente
	 */
	private static int pedirCantidadProductos(Scanner scanner) {
		String mensaje = "¿Cuántos productos diferentes vas a comprar?";
		return leerEnteroValidado(scanner, mensaje, MIN_PRODUCTOS, MAX_PRODUCTOS);
	}

	/**
	 * Registra todos los productos de una compra
	 * 
	 * @return subtotal de la compra (sin descuentos)
	 */
	private static double registrarProductos(Scanner scanner, int[] stock, String[] nombres, double[] precios,
			int[] unidades) {
		double subtotal = 0.0;

		for (int i = 0; i < nombres.length; i++) {
			System.out.println("\n--- PRODUCTO " + (i + 1) + " ---");

			// Pedir datos del producto
			nombres[i] = pedirNombreProducto(scanner, i);
			precios[i] = pedirPrecioProducto(scanner, i);
			unidades[i] = pedirUnidadesProducto(scanner, i);

			// Calcular subtotal parcial
			double totalLinea = precios[i] * unidades[i];
			subtotal += totalLinea;

			// Actualizar inventario
			actualizarInventario(stock, nombres[i], i, unidades[i]);
		}

		return subtotal;
	}

	/**
	 * Pide y valida el nombre de un producto
	 */
	private static String pedirNombreProducto(Scanner scanner, int numeroProducto) {
		String mensaje = "Nombre del producto " + (numeroProducto + 1) + ":";
		return leerTextoNoVacio(scanner, mensaje);
	}

	/**
	 * Pide y valida el precio de un producto
	 */
	private static double pedirPrecioProducto(Scanner scanner, int numeroProducto) {
		String mensaje = "Precio del producto " + (numeroProducto + 1) + " (€):";
		return leerDecimalValidado(scanner, mensaje, 0.0); // Precio mínimo 0€
	}

	/**
	 * Pide y valida las unidades de un producto
	 */
	private static int pedirUnidadesProducto(Scanner scanner, int numeroProducto) {
		String mensaje = "Unidades del producto " + (numeroProducto + 1) + ":";
		return leerEnteroValidado(scanner, mensaje, MIN_UNIDADES, MAX_UNIDADES);
	}

	/**
	 * Pregunta si el cliente es socio del establecimiento
	 */
	private static boolean esClienteSocio(Scanner scanner) {
		String mensaje = "¿Es socio de nuestra tienda?";
		return leerRespuestaSiNo(scanner, mensaje);
	}

	/**
	 * Pregunta si hay otro cliente esperando
	 */
	private static boolean preguntarOtraCompra(Scanner scanner) {
		String mensaje = "¿Hay otro cliente para atender?";
		return leerRespuestaSiNo(scanner, mensaje);
	}

	// ============= MÉTODOS DE VALIDACIÓN DE ENTRADA =============

	/**
	 * Lee un número entero validando que esté en un rango
	 */
	private static int leerEnteroValidado(Scanner scanner, String mensaje, int minimo, int maximo) {
		int valor = 0;
		boolean esValido = false;

		while (!esValido) {
			try {
				System.out.println(mensaje);
				valor = scanner.nextInt();
				scanner.nextLine(); // Limpiar buffer

				if (valor < minimo || valor > maximo) {
					System.out.println("Error: debe ser entre " + minimo + " y " + maximo);
				} else {
					esValido = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: introduce un número entero válido");
				scanner.nextLine(); // Limpiar entrada incorrecta
			}
		}

		return valor;
	}

	/**
	 * Lee un número decimal validando que sea mayor o igual a un mínimo
	 */
	private static double leerDecimalValidado(Scanner scanner, String mensaje, double minimo) {
		double valor = 0.0;
		boolean esValido = false;

		while (!esValido) {
			try {
				System.out.println(mensaje);
				valor = scanner.nextDouble();
				scanner.nextLine(); // Limpiar buffer

				if (valor < minimo) {
					System.out.println("Error: debe ser mayor o igual a " + minimo);
				} else {
					esValido = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: introduce un número válido (ej: 12.50)");
				scanner.nextLine(); // Limpiar entrada incorrecta
			}
		}

		return valor;
	}

	/**
	 * Lee texto asegurándose de que no esté vacío
	 */
	private static String leerTextoNoVacio(Scanner scanner, String mensaje) {
		String texto = "";

		while (texto.isEmpty()) {
			System.out.println(mensaje);
			texto = scanner.nextLine().trim();

			if (texto.isEmpty()) {
				System.out.println("Error: el nombre no puede estar vacío");
			}
		}

		return texto;
	}

	/**
	 * Lee una respuesta S/N y devuelve true para S, false para N
	 */
	private static boolean leerRespuestaSiNo(Scanner scanner, String mensaje) {
		while (true) {
			System.out.println(mensaje + " (S/N)");
			String respuesta = scanner.nextLine().trim().toUpperCase();

			if (respuesta.equals("S")) {
				return true;
			} else if (respuesta.equals("N")) {
				return false;
			} else {
				System.out.println("Error: responde solo con S (Sí) o N (No)");
			}
		}
	}

	// ============= MÉTODOS DE GESTIÓN DE STOCK =============

	/**
	 * Calcula en qué posición del array de stock se guarda un producto Usa una
	 * fórmula fija basada en el nombre y posición
	 */
	private static int calcularPosicionStock(String nombreProducto, int indiceProducto) {
		// Fórmula fija: longitud del nombre × 17 + índice × 3
		int calculo = (nombreProducto.length() * 17 + indiceProducto * 3);
		// Asegurar que está dentro del array
		return calculo % TAMANO_STOCK;
	}

	/**
	 * Actualiza el inventario restando las unidades vendidas
	 */
	private static void actualizarInventario(int[] stock, String nombreProducto, int indiceProducto,
			int unidadesVendidas) {
		int posicion = calcularPosicionStock(nombreProducto, indiceProducto);
		stock[posicion] -= unidadesVendidas; // Restar del stock

		// Verificar si nos quedamos sin existencias
		if (stock[posicion] < 0) {
			System.out.println("Aviso: este producto ha quedado con stock negativo");
		}
	}

	// ============= MÉTODOS DE CÁLCULO =============

	/**
	 * Calcula todos los importes de la factura
	 */
	private static ResultadoCalculos calcularImportes(double subtotal, boolean esSocio) {
		ResultadoCalculos resultado = new ResultadoCalculos();

		// 1. Descuento por compra grande (>100€)
		if (subtotal > UMBRAL_DESCUENTO) {
			resultado.descuentoVolumen = subtotal * DESCUENTO_MAS_DE_100;
		} else {
			resultado.descuentoVolumen = 0.0;
		}

		// 2. Calcular subtotal después del primer descuento
		double subtotalConDescuento = subtotal - resultado.descuentoVolumen;

		// 3. Descuento adicional para socios
		if (esSocio) {
			resultado.descuentoSocio = subtotalConDescuento * DESCUENTO_POR_SOCIO;
		} else {
			resultado.descuentoSocio = 0.0;
		}

		// 4. Calcular base imponible (después de todos los descuentos)
		resultado.baseImponible = subtotalConDescuento - resultado.descuentoSocio;

		// 5. Calcular IVA (21% sobre la base imponible)
		resultado.importeIVA = resultado.baseImponible * IVA;

		// 6. Calcular total final
		resultado.totalPagar = resultado.baseImponible + resultado.importeIVA;

		return resultado;
	}

	// ============= MÉTODOS DE SALIDA =============

	/**
	 * Muestra el ticket de compra completo con buen formato
	 */
	private static void mostrarTicket(String[] nombres, double[] precios, int[] unidades, double subtotal,
			ResultadoCalculos calculos) {

		System.out.println("\n" + "=".repeat(40));
		System.out.println("         TICKET DE COMPRA         ");
		System.out.println("=".repeat(40));

		// Detalle de productos
		System.out.println("PRODUCTOS COMPRADOS:");
		for (int i = 0; i < nombres.length; i++) {
			double totalLinea = precios[i] * unidades[i];
			System.out.printf("  %-15s %3d x %6.2f€ = %7.2f€%n", nombres[i], unidades[i], precios[i], totalLinea);
		}

		System.out.println("-".repeat(40));

		// Resumen de importes
		System.out.println("RESUMEN DE IMPORTES:");
		System.out.printf("  Subtotal:              %9.2f€%n", subtotal);
		System.out.printf("  Descuento (>100€):     %9.2f€%n", calculos.descuentoVolumen);
		System.out.printf("  Descuento socio:       %9.2f€%n", calculos.descuentoSocio);
		System.out.printf("  Base imponible:        %9.2f€%n", calculos.baseImponible);
		System.out.printf("  IVA (21%%):             %9.2f€%n", calculos.importeIVA);

		System.out.println("-".repeat(40));

		// Total a pagar
		System.out.printf("  TOTAL A PAGAR:         %9.2f€%n", calculos.totalPagar);

		System.out.println("=".repeat(40));
		System.out.println("¡Gracias por su compra!\n");
	}
}