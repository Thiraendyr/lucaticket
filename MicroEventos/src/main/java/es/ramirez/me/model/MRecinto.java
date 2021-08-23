package es.ramirez.me.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MRecinto.java clase que representa un recinto pero que no tiene interacción
 * con la base de datos.
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MRecinto {

	private Integer id_recinto;
	private String nombre;
	private String lugar;
	private String direccion;
	private Integer aforo;
}
