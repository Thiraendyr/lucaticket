package es.ramirez.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MicroEventosApplication.java clase principal
 * 
 * @author Leyanis Ramírez
 * @version 1.0,11/08/2021
 */
@SpringBootApplication
public class MicroEventosApplication {

	/**
	 * Método para iniciar la ejecución de la app
	 * 
	 * @param args obtener argumentos de línea de comando pasados ​​durante la
	 *             ejecución del programa
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroEventosApplication.class, args);
	}

}
