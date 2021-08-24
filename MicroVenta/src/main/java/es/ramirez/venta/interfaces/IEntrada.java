package es.ramirez.venta.interfaces;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.ramirez.venta.model.MEntrada;

/**
 * IEntrada.java interfaz donde se declaran las operaciones a realizar sobre la
 * base de datos del servicio entrada
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
public interface IEntrada {

	/**
	 * Método que realiza la búsqueda en la base de datos de una entrada dado su id
	 * 
	 * @param id identificador de la entrada
	 * @return MEntrada entrada encontrada
	 */
	public MEntrada findById(Integer id);

	/**
	 * Método que inserta en la base de datos una nueva entrada
	 * 
	 * @param me entrada a insertar
	 * @return String devuelve un mensaje si fue insertada o no la entrada
	 */
	public String crearEntrada(MEntrada me);

	/**
	 * Método que realiza una búsqueda de una entrada en la base de datos, lo
	 * modifica y lo inserta.
	 * 
	 * @param me entrada a actualizar
	 * @return String devuelve un mensaje si fue modificada o no la entrada
	 */
	public String editarEntrada(MEntrada me);

	/**
	 * Método que realiza la búsqueda en la base de datos de una entrada para
	 * eliminarla
	 * 
	 * @param id identificador de la entrada
	 * @return String devuelve un mensaje si fue eliminada o no la entrada
	 */
	public String deleteById(Integer id);

	/**
	 * Método que realiza la búsqueda en la base de datos de las entradas
	 * 
	 * @return entradas existentes
	 */
	public List<MEntrada> findAll();

	/**
	 * Método que realiza la búsqueda en la base de datos de una entrada dado su
	 * nombre
	 * 
	 * @param nombre nombre de una entrada
	 * @return entradas encontradas
	 */
	public List<MEntrada> findByNombre(String nombre);

	/**
	 * Método que realiza la búsqueda en la base de datos de una entrada dado su
	 * tipo
	 * 
	 * @param tipoEntrada tipo de entrada
	 * @return entradas encontradas
	 */
	public List<MEntrada> findByTipo(String tipoEntrada);

	/**
	 * Método que realiza la reserva de las entradas
	 * 
	 * @param idEntrada identificador de la entrada a reservar
	 * @return true o false si fue realizada la reserva
	 * @throws JsonProcessingException Excepcion para procesar un json
	 */
	public boolean pagoTickest(Integer idEntrada) throws JsonProcessingException;

}
