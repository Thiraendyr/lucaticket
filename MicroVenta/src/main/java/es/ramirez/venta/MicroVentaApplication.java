package es.ramirez.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MicroVentaApplication.java clase principal
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@SpringBootApplication
public class MicroVentaApplication {

	/**
	 * Método para iniciar la ejecución de la app
	 * 
	 * @param args obtener argumentos de línea de comando pasados ​​durante la
	 *             ejecución del programa
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroVentaApplication.class, args);
	}

}
