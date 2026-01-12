package ejercicios_parte1;

public class Persona {
	String dni;
	String nombre; 
	String apellidos; 
	Double edad;

    // Método para comprobar si es mayor de edad
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
}
