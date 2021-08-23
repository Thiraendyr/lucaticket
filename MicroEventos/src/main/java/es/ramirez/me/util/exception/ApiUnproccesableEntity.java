package es.ramirez.me.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ApiUnproccesableEntity.java excepcion personalizada de estado 422
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 16/08/2021
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnproccesableEntity extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor con el mensaje de error
	 * 
	 * @param mensaje el mensaje de error
	 */
	public ApiUnproccesableEntity(String mensaje) {
		super(mensaje);
	}
}
