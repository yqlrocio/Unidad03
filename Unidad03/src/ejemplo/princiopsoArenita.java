package ejemplo;

import java.nio.file.spi.FileSystemProvider;

public class princiopsoArenita {

	public static void main(String[] args) {
		
		Persona daniel = new Persona(); 
		
		System.out.println (daniel);
		
		System.out.println(daniel.nombre);
		daniel.nombre = "Daniel";
		System.out.println(daniel.nombre);
		System.out.println(daniel.edad);
		System.out.println(daniel.estatura);
		System.out.println(daniel.carnet);
		
	}

}
