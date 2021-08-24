package es.ramirez.venta.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * * Entrada.java entidad que interactúa directamente con la base de datos.
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entrada")
public class Entrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador de la entrada
	 */
	@Id
	@Column(name = "idEntrada")
	private int idEntrada;

	/**
	 * identificador del evento
	 */
	@Column(name = "idEvento")
	private int idEvento;

	/**
	 * identificador del comprador
	 */
	@Column(name = "idUsuario")
	private int idUsuario;

	/**
	 * cantidad de entradas en un pedido
	 */
	@Column(name = "entradasPorPedido")
	private int entradasPorPedido;

	/**
	 * nombre de la entrada
	 */
	@Column(name = "nombreEntrada")
	private String nombreEntrada;

	/**
	 * tipo de entrada
	 */
	@Column(name = "tipoEntrada")
	private String tipoEntrada;

	/**
	 * tarifa de la entrada
	 */
	@Column(name = "tarifa")
	private String tarifa;

	/**
	 * tipo de pago
	 */
	@Column(name = "tipoPago")
	private String tipoPago;

	/**
	 * estado de la reserva
	 */
	@Column(name = "estadoReserva")
	private String estadoReserva;

	/**
	 * fecha de inicio de la reserva
	 */
	@Column(name = "fechaInicioVenta")
	private Date fechaInicioVenta;

	/**
	 * fecha fin de la reserva
	 */
	@Column(name = "fechaFinVenta")
	private Date fechaFinVenta;

	/**
	 * impuesto de la venta
	 */
	@Column(name = "iva")
	private Double iva;

	/**
	 * precio del evento
	 */
	@Column(name = "precio")
	private Double precio;

	/**
	 * iva a pagar
	 */
	@Column(name = "ivaAPagar")
	private Double ivaAPagar;

	/**
	 * precio * entradasPorPedido
	 */
	@Column(name = "subtotal")
	private Double subtotal;

	/**
	 * saldo final a pagar
	 */
	@Column(name = "saldoFinal")
	private Double saldoFinal;

}
