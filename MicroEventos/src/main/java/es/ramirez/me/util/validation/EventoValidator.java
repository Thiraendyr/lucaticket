package es.ramirez.me.util.validation;

import es.ramirez.me.model.MEvento;
import es.ramirez.me.util.exception.ApiUnproccesableEntity;

/**
 * EventoValidator.java interfaz personalizada de estado 422
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 16/08/2021
 */
public interface EventoValidator {

	/**
	 * Método que valida un evento
	 * 
	 * @param mevento un evento
	 * @throws ApiUnproccesableEntity Excepcion para el estado 422
	 */
	void validator(MEvento mevento) throws ApiUnproccesableEntity;
}
