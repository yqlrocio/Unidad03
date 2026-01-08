package clean_code;

import java.util.Scanner;

public class CajaHorrible {

	/**
	 * Sistema de Caja Registradora Permite registrar compras, calcular descuentos y
	 * emitir tickets
	 */

	// ==================== CONSTANTES ====================
	// Estas son valores que no cambian durante la ejecución del programa

	private static final double VAT_RATE = 0.21; // IVA del 21%
	private static final double BULK_DISCOUNT_THRESHOLD = 100.0; // Límite para descuento por volumen
	private static final double BULK_DISCOUNT_RATE = 0.10; // 10% descuento por compras grandes
	private static final double MEMBER_DISCOUNT_RATE = 0.05; // 5% descuento para socios
	private static final int INITIAL_STOCK = 10; // Stock inicial de cada producto
	private static final int STOCK_ARRAY_SIZE = 200; // Tamaño del array de stock

	// ==================== CLASES INTERNAS ====================
	// Organizamos el código en clases pequeñas y específicas

	/**
	 * Representa un producto individual en la compra
	 */
	private static class Product {
		String name; // Nombre del producto
		double price; // Precio unitario
		int quantity; // Cantidad comprada

		// Constructor: crea un nuevo producto asegurando valores válidos
		public Product(String name, double price, int quantity) {
			this.name = name;
			this.price = Math.abs(price); // El precio siempre es positivo
			this.quantity = Math.max(1, Math.abs(quantity)); // Mínimo 1 unidad
		}

		// Calcula el total de esta línea (precio × cantidad)
		public double getLineTotal() {
			return price * quantity;
		}
	}

	/**
	 * Representa el carrito de compras del cliente
	 */
	private static class ShoppingCart {
		Product[] products; // Array de productos en el carrito
		int productCount; // Número real de productos añadidos

		// Constructor: prepara el carrito para un máximo de productos
		public ShoppingCart(int maxProducts) {
			products = new Product[maxProducts];
			productCount = 0; // Empieza vacío
		}

		// Añade un producto al carrito
		public void addProduct(Product product) {
			if (productCount < products.length) {
				products[productCount++] = product; // Añade y aumenta el contador
			}
		}

		// Calcula el subtotal sumando todos los productos
		public double calculateSubtotal() {
			double subtotal = 0;
			for (int i = 0; i < productCount; i++) {
				subtotal += products[i].getLineTotal();
			}
			return subtotal;
		}
	}

	/**
	 * Gestiona el inventario de productos
	 */
	private static class StockManager {
		private int[] stock; // Array que representa el stock disponible

		public StockManager() {
			stock = new int[STOCK_ARRAY_SIZE];
			initializeStock(); // Llena el stock con valores iniciales
		}

		// Pone todo el stock a su valor inicial
		private void initializeStock() {
			for (int i = 0; i < stock.length; i++) {
				stock[i] = INITIAL_STOCK; // Cada producto empieza con 10 unidades
			}
		}

		// Calcula una posición en el array de stock basada en el nombre
		public int calculateStockIndex(String productName, int productIndex) {
			// Fórmula para distribuir productos en el array
			return (productName.length() * 17 + productIndex * 3) % STOCK_ARRAY_SIZE;
		}

		// Reduce el stock cuando se vende un producto
		public void updateStock(String productName, int productIndex, int quantity) {
			int stockIndex = calculateStockIndex(productName, productIndex);
			stock[stockIndex] -= quantity; // Resta las unidades vendidas

			// Avisa si nos quedamos sin stock (pero permite ventas negativas)
			if (stock[stockIndex] < 0) {
				System.out.println("Advertencia: Stock negativo para el producto");
			}
		}
	}

	/**
	 * Calcula todos los importes de la factura
	 */
	private static class InvoiceCalculator {
		public static Invoice calculateInvoice(double subtotal, boolean isMember) {
			Invoice invoice = new Invoice();
			invoice.subtotal = subtotal;

			// DESCUENTO 1: Por compras mayores a 100€
			if (subtotal > BULK_DISCOUNT_THRESHOLD) {
				invoice.bulkDiscount = subtotal * BULK_DISCOUNT_RATE; // 10% descuento
			} else {
				invoice.bulkDiscount = 0.0; // No hay descuento
			}

			double amountAfterBulkDiscount = subtotal - invoice.bulkDiscount;

			// DESCUENTO 2: Para socios (sobre el importe ya descontado)
			if (isMember) {
				invoice.memberDiscount = amountAfterBulkDiscount * MEMBER_DISCOUNT_RATE; // 5% descuento
			} else {
				invoice.memberDiscount = 0.0; // No es socio, no hay descuento
			}

			// Cálculo de base imponible (después de todos los descuentos)
			invoice.taxableBase = amountAfterBulkDiscount - invoice.memberDiscount;

			// Cálculo del IVA (21% sobre la base imponible)
			invoice.vatAmount = invoice.taxableBase * VAT_RATE;

			// Total a pagar (base + IVA)
			invoice.totalAmount = invoice.taxableBase + invoice.vatAmount;

			return invoice;
		}
	}

	/**
	 * Almacena todos los importes de una factura
	 */
	private static class Invoice {
		double subtotal; // Suma de todos los productos sin descuentos
		double bulkDiscount; // Descuento por compra mayor a 100€
		double memberDiscount; // Descuento para socios
		double taxableBase; // Importe sobre el que se calcula el IVA
		double vatAmount; // Importe del IVA
		double totalAmount; // Total final a pagar
	}

	// ==================== MÉTODO PRINCIPAL ====================
	/**
	 * Punto de entrada del programa
	 */
	public static void main(String[] args) {
		// Preparamos el scanner para leer entrada del usuario
		Scanner scanner = new Scanner(System.in);

		// Creamos el gestor de stock
		StockManager stockManager = new StockManager();

		// Mostramos mensaje de bienvenida
		displayWelcomeMessage();

		// Variable para controlar si seguimos atendiendo clientes
		boolean continueShopping = true;

		// Bucle principal: atiende un cliente, luego pregunta si hay otro
		while (continueShopping) {
			// PASO 1: Tomar el pedido del cliente
			ShoppingCart cart = processCustomerOrder(scanner, stockManager);

			// PASO 2: Preguntar si es socio
			boolean isMember = askForMembership(scanner);

			// PASO 3: Calcular la factura
			Invoice invoice = InvoiceCalculator.calculateInvoice(cart.calculateSubtotal(), isMember);

			// PASO 4: Imprimir el ticket
			printInvoice(cart, invoice);

			// PASO 5: Preguntar si hay otro cliente
			continueShopping = askForAnotherPurchase(scanner);
		}

		// El usuario dijo que no hay más clientes
		displayGoodbyeMessage();

		// Cerramos el scanner para liberar recursos
		scanner.close();
	}

	// ==================== MÉTODOS AUXILIARES ====================

	/**
	 * Muestra el mensaje inicial del programa
	 */
	private static void displayWelcomeMessage() {
		System.out.println("=== Sistema de Caja Registradora ===");
		System.out.println("Bienvenido al sistema de gestión de compras");
	}

	/**
	 * Muestra el mensaje de despedida
	 */
	private static void displayGoodbyeMessage() {
		System.out.println("\n¡Gracias por su visita! Hasta pronto.");
	}

	/**
	 * Procesa un pedido completo de un cliente
	 * 
	 * @return Carrito de compras lleno con los productos
	 */
	private static ShoppingCart processCustomerOrder(Scanner scanner, StockManager stockManager) {
		// Preguntamos cuántos productos diferentes va a comprar
		System.out.print("\n¿Cuántos productos desea registrar? ");
		int productCount = scanner.nextInt();
		scanner.nextLine(); // Limpiamos el buffer del teclado

		// Creamos un carrito nuevo para este cliente
		ShoppingCart cart = new ShoppingCart(productCount);

		// Bucle para registrar cada producto
		for (int i = 0; i < productCount; i++) {
			// Leemos los datos del producto
			Product product = readProductDetails(scanner, i);

			// Lo añadimos al carrito
			cart.addProduct(product);

			// Actualizamos el stock (restamos lo vendido)
			stockManager.updateStock(product.name, i, product.quantity);
		}

		return cart;
	}

	/**
	 * Lee los datos de un producto desde el teclado
	 * 
	 * @param productIndex Número del producto (para mostrar en pantalla)
	 * @return Producto creado con los datos introducidos
	 */
	private static Product readProductDetails(Scanner scanner, int productIndex) {
		System.out.println("\n--- Producto " + (productIndex + 1) + " ---");

		// Leer nombre
		System.out.print("Nombre del producto: ");
		String name = scanner.nextLine();

		// Leer precio
		System.out.print("Precio unitario: ");
		double price = scanner.nextDouble();

		// Leer cantidad
		System.out.print("Cantidad: ");
		int quantity = scanner.nextInt();
		scanner.nextLine(); // Limpiar buffer

		// Creamos y devolvemos el producto
		return new Product(name, price, quantity);
	}

	/**
	 * Pregunta al cliente si es socio
	 * 
	 * @return true si es socio, false si no lo es
	 */
	private static boolean askForMembership(Scanner scanner) {
		System.out.print("\n¿Es socio? (S/N): ");
		String response = scanner.nextLine().trim().toUpperCase(); // Convertimos a mayúsculas
		return response.equals("S"); // Devuelve true si escribió "S"
	}

	/**
	 * Pregunta si hay otro cliente esperando
	 * 
	 * @return true si hay otro cliente, false si no
	 */
	private static boolean askForAnotherPurchase(Scanner scanner) {
		System.out.print("\n¿Desea realizar otra compra? (S/N): ");
		String response = scanner.nextLine().trim().toUpperCase(); // Convertimos a mayúsculas
		return response.equals("S"); // Devuelve true si escribió "S"
	}

	/**
	 * Imprime el ticket de compra con formato
	 * 
	 * @param cart    Carrito con los productos comprados
	 * @param invoice Factura con todos los importes calculados
	 */
	private static void printInvoice(ShoppingCart cart, Invoice invoice) {
		// Encabezado del ticket
		System.out.println("\n" + "=".repeat(40));
		System.out.println("TICKET DE COMPRA");
		System.out.println("=".repeat(40));

		// Detalle de cada producto
		System.out.println("PRODUCTOS:");
		for (int i = 0; i < cart.productCount; i++) {
			Product product = cart.products[i];
			// Formato: Nombre, cantidad, precio, total línea
			System.out.printf("  %-20s %3d x %6.2f€ = %8.2f€%n", product.name, product.quantity, product.price,
					product.getLineTotal());
		}

		// Línea separadora
		System.out.println("-".repeat(40));

		// Resumen financiero
		System.out.println("RESUMEN:");
		System.out.printf("  Subtotal:                 %10.2f€%n", invoice.subtotal);
		System.out.printf("  Descuento por volumen:    %10.2f€%n", invoice.bulkDiscount);
		System.out.printf("  Descuento socio:          %10.2f€%n", invoice.memberDiscount);
		System.out.printf("  Base imponible:           %10.2f€%n", invoice.taxableBase);
		System.out.printf("  IVA (21%%):                %10.2f€%n", invoice.vatAmount);

		// Otra línea separadora
		System.out.println("-".repeat(40));

		// Total final (lo más importante)
		System.out.printf("  TOTAL A PAGAR:            %10.2f€%n", invoice.totalAmount);

		// Pie del ticket
		System.out.println("=".repeat(40));
		System.out.println("¡Gracias por su compra!");
	}
}