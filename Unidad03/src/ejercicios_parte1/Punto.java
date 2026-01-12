package ejercicios_parte1;

public class Punto {
	int x; 
	int y; 
	

	 // Constructor
	public Punto(int x, int y) {
	   this.x = x;
	   this.y = y;
	}

	 // Método para mostrar las coordenadas
	public void mostrar() {
		System.out.println("Punto (" + x + ", " + y + ")");
	 }
}

