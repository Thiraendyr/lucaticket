package es.ramirez.me.interfaces;

import java.util.List;

import es.ramirez.me.model.MEvento;

/**
 * IEvento.java interfaz donde se declaran las operaciones a realizar sobre la
 * base de datos del servicio evento
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
public interface IEvento {

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su id
	 * 
	 * @param id identificador del evento
	 * @return MEvento evento encontrado
	 */
	public MEvento findById(Integer id);

	/**
	 * Método que inserta en la base de datos un nuevo evento
	 * 
	 * @param me evento a insertar
	 * @return String devuelve un mensaje si fue insertado o no el evento
	 */
	public String crearEvento(MEvento me);

	/**
	 * Método que realiza una búsqueda de un evento en la base de datos, lo modifica
	 * y lo inserta.
	 * 
	 * @param me evento a actualizar
	 * @return String devuelve un mensaje si fue modificado o no el evento
	 */
	public String editarEvento(MEvento me);

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
	public List<MEvento> findAll();

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su
	 * nombre
	 * 
	 * @param nombre contenido de un evento
	 * @return eventos encontrados
	 */
	public List<MEvento> findByNombre(String nombre);

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su
	 * ciudad
	 * 
	 * @param ciudad lugar de celebración de un evento
	 * @return eventos encontrados
	 */
	public List<MEvento> findByCiudad(String ciudad);

	/**
	 * Método que realiza la búsqueda en la base de datos de un evento dado su
	 * género
	 * 
	 * @param tipoGenero género de un evento
	 * @return eventos encontrados
	 */
	public List<MEvento> findByTipoGenero(String tipoGenero);
}
