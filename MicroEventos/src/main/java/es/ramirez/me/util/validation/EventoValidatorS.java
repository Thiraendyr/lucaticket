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
			this.menssage("El nombre es muy corto, debe tener mínimo 3 carácteres");
		}

		if (mevento.getDesc_corta() == null || mevento.getDesc_corta().isEmpty()) {
			this.menssage("La descripción corta es obligatoria");
		}
		if (mevento.getDesc_corta().length() < 5) {
			this.menssage("La descripión es muy corta, debe tener mínimo 5 carácteres");
		}

		if (mevento.getDesc_ext() == null || mevento.getDesc_ext().isEmpty()) {
			this.menssage("La descripción larga es obligatoria");
		}
		if (mevento.getDesc_ext().length() < 10) {
			this.menssage("La descripión larga es muy corta, debe tener mínimo 10 carácteres");
		}

		if (mevento.getGenero() == null || mevento.getGenero().isEmpty()) {
			this.menssage("El género es obligatorio");
		}
		if (mevento.getGenero().length() < 5) {
			this.menssage("El género es muy corto, debe tener mínimo 5 carácteres");
		}

		if (mevento.getPolitica_acceso() == null || mevento.getPolitica_acceso().isEmpty()) {
			this.menssage("La política de acceso es obligatoria");
		}
		if (mevento.getPolitica_acceso().length() < 5) {
			this.menssage("La política de acceso es muy corta, debe tener mínimo 5 carácteres");
		}
		
		if (mevento.getPrecio() == 0.0) {
			this.menssage("El precio es obligatorio");
		}
	
		if (mevento.getMrecinto() == null) {
			this.menssage("El recinto es obligatorio");
		}
	}

	private void menssage(String message) throws ApiUnproccesableEntity {
		throw new ApiUnproccesableEntity(message);
	}
}
