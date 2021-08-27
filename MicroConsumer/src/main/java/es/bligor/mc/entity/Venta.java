package es.bligor.mc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("MEntrada")
public class Venta {

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
