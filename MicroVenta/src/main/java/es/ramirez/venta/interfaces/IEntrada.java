package es.ramirez.venta.interfaces;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.ramirez.venta.model.MEntrada;

/**
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
public interface IEntrada {

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su id
	 * 
	 * @param id identificador del evento
	 * @return MEvento evento encontrado
	 */
	public MEntrada findById(Integer id);

	/**
	 * Método que inserta en la base de datos un nuevo evento
	 * 
	 * @param me evento a insertar
	 * @return String devuelve un mensaje si fue insertado o no el evento
	 */
	public String crearEntrada(MEntrada me);

	/**
	 * Método que realiza una búsqueda de un evento en la base de datos, lo modifica
	 * y lo inserta.
	 * 
	 * @param me evento a actualizar
	 * @return String devuelve un mensaje si fue modificado o no el evento
	 */
	public String editarEntrada(MEntrada me);

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento para
	 * eliminarlo
	 * 
	 * @param id identificador del evento
	 * @return String devuelve un mensaje si fue eliminado o no el evento
	 */
	public String deleteById(Integer id);

	/**
	 * Método que realiza la búsqueda en la base de datos de los eventos
	 * 
	 * @return eventos existentes
	 */
	public List<MEntrada> findAll();

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su
	 * nombre
	 * 
	 * @param nombre contenido de un evento
	 * @return eventos encontrados
	 */
	public List<MEntrada> findByNombre(String nombre);

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su
	 * género
	 * 
	 * @param tipoGenero género de un evento
	 * @return eventos encontrados
	 */
	public List<MEntrada> findByTipo(String tipoEntrada);

//	/**
//	 * 
//	 * @param precio
//	 * @param ivaPorciento
//	 * @param entradasPorPedido
//	 * @return
//	 */
//	public Double ivaAPagar(Double precio, Double ivaPorciento, int entradasPorPedido);
//
//	/**
//	 * 
//	 * @param precio
//	 * @param ivaPorciento
//	 * @param entradasPorPedido
//	 * @return
//	 */
//	public Double saldoFinal(Double precio, Double ivaPorciento, int entradasPorPedido);
//
//	/**
//	 * 
//	 * @param precio
//	 * @param entradasPorPedido
//	 * @return
//	 */
//	public Double subTotal(Double precio, int entradasPorPedido);

	/**
	 * 
	 * @param pago
	 * @param id
	 * @return
	 */
	public boolean pagoTickest(Integer idEntrada) throws JsonProcessingException;

}
