package ejercicios_parte1;

public class Rectangulo {
	int x1, y1, x2, y2;

	// Constructor
	public Rectangulo(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	// Método para obtener el ancho
	public int getAncho() {
		return Math.abs(x2 - x1);
	}

	// Método para obtener el alto
	public int getAlto() {
		return Math.abs(y2 - y1);
	}

	 // Método para calcular el perímetro
	 public int getPerimetro() {
		 return 2 * (getAncho() + getAlto());
		    }

	// Método para calcular el área
	public int getArea() {
		return getAncho() * getAlto();
	}

	// Método para mostrar las coordenadas
	public void mostrar() {
		System.out.println("Coordenadas: (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
		
		System.out.println("Perímetro: " + getPerimetro());
		
		System.out.println("Área: " + getArea());
		       
		System.out.println();
	}
		
}
