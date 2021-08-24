package es.ramirez.venta.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MEntrada {

	private int idEntrada;

	private int idEvento;

	private int idUsuario;

	private int entradasPorPedido;

	private String nombreEntrada;

	private String tipoEntrada;

	private String tarifa;

	private String tipoPago;

	private String estadoReserva;

	private Date fechaInicioVenta;

	private Date fechaFinVenta;

	private Double iva;

	private Double precio;

	private Double ivaAPagar;

	private Double subtotal;

	private Double saldoFinal;
}
