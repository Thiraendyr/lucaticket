package es.ramirez.me.util.validation;

import org.springframework.stereotype.Service;

import es.ramirez.me.model.MEvento;
import es.ramirez.me.util.exception.ApiUnproccesableEntity;


/**
 * EventoValidatorS.java servicio personalizada de estado 422
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 16/08/2021
 */
@Service
public class EventoValidatorS implements EventoValidator {

	@Override
	public void validator(MEvento mevento) throws ApiUnproccesableEntity {
		if (mevento.getNombre() == null || mevento.getNombre().isEmpty()) {
			this.menssage("El nombre es obligatorio");
		}
		if (mevento.getNombre().length() < 3) {
			this.menssage("El nombre es muy corto, debe tener minimo 3 carácteres");
		}
	}

	private void menssage(String message) throws ApiUnproccesableEntity {
		throw new ApiUnproccesableEntity(message);
	}
}
