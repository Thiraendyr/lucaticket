package es.ramirez.venta.util;

import java.util.ArrayList;
import java.util.List;

import es.ramirez.venta.model.MEntrada;
import es.ramirez.venta.model.entity.Entrada;


/**
 * Convertidor.java clase que convierte de modelo a entidades y viceversa
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 11/08/2021
 */
public class Convertidor {

	/**
	 * Método que convierte una entidad entrada a una entrada del modelo
	 * 
	 * @param e una entrada entidad
	 * @return una entrada del modelo
	 */
	public static MEntrada entradaEntityToModel(Entrada e) {
		MEntrada mentrada = new MEntrada();
		mentrada.setIdEntrada(e.getIdEntrada());
		mentrada.setIdEvento(e.getIdEvento());
		mentrada.setIdUsuario(e.getIdUsuario());
		mentrada.setNombreEntrada(e.getNombreEntrada());
		mentrada.setTipoEntrada(e.getTipoEntrada());
		mentrada.setEntradasPorPedido(e.getEntradasPorPedido());
		mentrada.setEstadoReserva(e.getEstadoReserva());
		mentrada.setIva(e.getIva());
		mentrada.setPrecio(e.getPrecio());
		mentrada.setIvaAPagar((e.getPrecio() * e.getEntradasPorPedido()) * e.getIva() / 100);
	    mentrada.setSubtotal(e.getPrecio() * e.getEntradasPorPedido());
		mentrada.setSaldoFinal((e.getPrecio() * e.getEntradasPorPedido()) + ((e.getPrecio() * e.getEntradasPorPedido()) * e.getIva() / 100));
		mentrada.setTarifa(e.getTarifa());
		mentrada.setTipoPago(e.getTipoPago());
		mentrada.setFechaInicioVenta(e.getFechaInicioVenta());
		mentrada.setFechaFinVenta(e.getFechaFinVenta());
		return mentrada;
	}

	/**
	 * Método que convierte una entrada del modelo a una entidad entrada
	 * 
	 * @param me una entrada del modelo
	 * @return una entrada entidad
	 */
	public static Entrada mentradaToEntity(MEntrada me) {
		Entrada entrada = new Entrada();
		entrada.setIdEntrada(me.getIdEntrada());
		entrada.setIdEvento(me.getIdEvento());
		entrada.setIdUsuario(me.getIdUsuario());
		entrada.setNombreEntrada(me.getNombreEntrada());
		entrada.setTipoEntrada(me.getTipoEntrada());
		entrada.setEntradasPorPedido(me.getEntradasPorPedido());
		entrada.setEstadoReserva(me.getEstadoReserva());
		entrada.setIva(me.getIva());
		entrada.setPrecio(me.getPrecio());
		entrada.setIvaAPagar((me.getPrecio() * me.getEntradasPorPedido()) * me.getIva() / 100);
		entrada.setSubtotal(me.getPrecio() * me.getEntradasPorPedido());
		entrada.setSaldoFinal((me.getPrecio() * me.getEntradasPorPedido()) + ((me.getPrecio() * me.getEntradasPorPedido()) * me.getIva() / 100));
		entrada.setTarifa(me.getTarifa());
		entrada.setTipoPago(me.getTipoPago());
		entrada.setFechaInicioVenta(me.getFechaInicioVenta());
		entrada.setFechaFinVenta(me.getFechaFinVenta());
		return entrada;
	}

	/**
	 * Método que convierte una lista de entradas del modelo a entradas entidad
	 * 
	 * @param me lista de entradas del modelo
	 * @return lista de entradas entidad
	 */
	public static List<Entrada> listMEntradaToEntity(List<MEntrada> me) {
		List<Entrada> entradas = new ArrayList<Entrada>();
		for (MEntrada mentrada : me) {
			entradas.add(mentradaToEntity(mentrada));
		}
		return entradas;
	}

	/**
	 * Método que convierte una lista de entradas entidad a entradas del modelo
	 * 
	 * @param eventos lista de entradas entidad
	 * @return lista de entradas modelo
	 */
	public static List<MEntrada> listEntradaEntityToModel(List<Entrada> entradas) {
		List<MEntrada> mentradas = new ArrayList<MEntrada>();
		for (Entrada entrada : entradas) {
			mentradas.add(entradaEntityToModel(entrada));
		}
		return mentradas;
	}

}
