package es.ramirez.me.model.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Recinto.java clase que representa un recinto donde se celebra un evento, es
 * un objeto dentro de la document evento
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recinto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * identificador de un recinto
	 */
	@Id
	private Integer id_recinto;
	/**
	 * nombre de un recinto
	 */
	private String nombre;
	/**
	 * ciudad donde se encuentra un recinto
	 */
	private String lugar;
	/**
	 * localización de un recinto
	 */
	private String direccion;
	/**
	 * cantidad de personas dentro de un recinto
	 */
	private Integer aforo;

}
