package es.ramirez.venta.util.validation;

import es.ramirez.venta.model.MEntrada;
import es.ramirez.venta.util.exception.ApiUnproccesableEntity;

/**
 * EntradaValidator.java interfaz personalizada de estado 422
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 16/08/2021
 */
public interface EntradaValidator {

	/**
	 * Método que valida una entrada
	 * 
	 * @param mentrada una entrada
	 * @throws ApiUnproccesableEntity Excepcion para el estado 422
	 */
	void validator(MEntrada mentrada) throws ApiUnproccesableEntity;
}
