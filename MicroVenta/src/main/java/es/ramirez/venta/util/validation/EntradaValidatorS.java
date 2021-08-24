package es.ramirez.venta.util.validation;

import org.springframework.stereotype.Service;

import es.ramirez.venta.model.MEntrada;
import es.ramirez.venta.util.exception.ApiUnproccesableEntity;

/**
 * EntradaValidatorS.java servicio personalizada de estado 422
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 16/08/2021
 */
@Service
public class EntradaValidatorS implements EntradaValidator {

	@Override
	public void validator(MEntrada mentrada) throws ApiUnproccesableEntity {
		if (mentrada.getEntradasPorPedido() == 0) {
			this.menssage("Debe seleccionar al meno un ticket por pedido");
		}
		
		if (mentrada.getEntradasPorPedido() > 4) {
			this.menssage("El máximo es 4 tickets por pedido");
		}
	}

	private void menssage(String message) throws ApiUnproccesableEntity {
		throw new ApiUnproccesableEntity(message);
	}
}
