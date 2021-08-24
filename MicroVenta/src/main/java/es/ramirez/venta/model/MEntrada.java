package es.ramirez.venta.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MEntrada.java clase que representa una entradaS pero que no tiene interacción con
 * la base de datos.
 *  
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MEntrada {

	@ApiModelProperty(value = "idEntrada identificador de la entrada")
	private int idEntrada;

	@ApiModelProperty(value = "idEvento identificador de un evento")
	private int idEvento;

	@ApiModelProperty(value = "idUsuario identificador del comprador")
	private int idUsuario;
	
	@ApiModelProperty(value = "entradasPorPedido cantidad de entradas en un pedido")
	private int entradasPorPedido;

	@ApiModelProperty(value = "nombreEntrada nombre de la entrada")
	private String nombreEntrada;

	@ApiModelProperty(value = "tipoEntrada tipo de entrada")
	private String tipoEntrada;

	@ApiModelProperty(value = "tarifa tarifa de la entrada")
	private String tarifa;

	@ApiModelProperty(value = "tipoPago tipo de pago")
	private String tipoPago;

	@ApiModelProperty(value = "estadoReserva estado de la reserva")
	private String estadoReserva;

	@ApiModelProperty(value = "fechaInicioVenta fecha de inicio de la reserva")
	private Date fechaInicioVenta;

	@ApiModelProperty(value = "fechaFinVenta fecha fin de la reserva")
	private Date fechaFinVenta;

	@ApiModelProperty(value = "iva impuesto de la venta")
	private Double iva;

	@ApiModelProperty(value = "precio precio del evento")
	private Double precio;

	@ApiModelProperty(value = "ivaAPagar iva a pagar")
	private Double ivaAPagar;

	@ApiModelProperty(value = "subtotal precio * entradasPorPedido")
	private Double subtotal;

	@ApiModelProperty(value = "saldoFinal saldo final a pagar")
	private Double saldoFinal;
}
