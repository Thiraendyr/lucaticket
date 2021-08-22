package es.ramirez.me.util;

import java.util.ArrayList;
import java.util.List;

import es.ramirez.me.model.MEvento;
import es.ramirez.me.model.MRecinto;
import es.ramirez.me.model.entities.Evento;
import es.ramirez.me.model.entities.Recinto;

/**
 * Convertidor.java clase que convierte de modelo a entidades y viceversa
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 11/08/2021
 */
public class Convertidor {

	/**
	 * Método que convierte una entidad evento a un evento del modelo
	 * 
	 * @param e un evento entidad
	 * @return un evento del modelo
	 */
	public static MEvento eventoEntityToModel(Evento e) {
		MEvento mevento = new MEvento();
		mevento.setId_evento(e.getId_evento());
		mevento.setId_usuario(e.getId_usuario());
		mevento.setNombre(e.getNombre());
		mevento.setDesc_corta(e.getDesc_corta());
		mevento.setDesc_ext(e.getDesc_ext());
		mevento.setFechaHora(e.getFechaHora());
		mevento.setFoto(e.getFoto());
		mevento.setGenero(e.getGenero());
		mevento.setPolitica_acceso(e.getPolitica_acceso());
		mevento.setPrecio(e.getPrecio());
		mevento.setMrecinto(recintoEntityToModel(e.getRecinto()));
		return mevento;
	}

	/**
	 * Método que convierte un evento del modelo a una entidad evento
	 * 
	 * @param me un evento del modelo
	 * @return un evento entidad
	 */
	public static Evento meventoToEntity(MEvento me) {
		Evento evento = new Evento();
		evento.setId_evento(me.getId_evento());
		evento.setId_usuario(me.getId_usuario());
		evento.setNombre(me.getNombre());
		evento.setDesc_corta(me.getDesc_corta());
		evento.setDesc_ext(me.getDesc_ext());
		evento.setFechaHora(me.getFechaHora());
		evento.setFoto(me.getFoto());
		evento.setGenero(me.getGenero());
		evento.setPolitica_acceso(me.getPolitica_acceso());
		evento.setPrecio(me.getPrecio());
		evento.setRecinto(mrecintoToEntity(me.getMrecinto()));
		return evento;
	}

	/**
	 * Método que convierte una entidad recinto a un recinto del modelo
	 * 
	 * @param rencito objeto de la entidad
	 * @return un recinto del modelo
	 */
	public static MRecinto recintoEntityToModel(Recinto rencito) {
		MRecinto mrecinto = new MRecinto();
		mrecinto.setId_recinto(rencito.getId_recinto());
		mrecinto.setAforo(rencito.getAforo());
		mrecinto.setDireccion(rencito.getDireccion());
		mrecinto.setLugar(rencito.getLugar());
		mrecinto.setNombre(rencito.getNombre());
		return mrecinto;
	}

	/**
	 * Método que convierte un recinto del modelo a una entidad recinto
	 * 
	 * @param mr un recinto del modelo
	 * @return un recinto entidad
	 */
	public static Recinto mrecintoToEntity(MRecinto mr) {
		Recinto recinto = new Recinto();
		recinto.setId_recinto(mr.getId_recinto());
		recinto.setAforo(mr.getAforo());
		recinto.setDireccion(mr.getDireccion());
		recinto.setLugar(mr.getLugar());
		recinto.setNombre(mr.getNombre());
		return recinto;
	}

	/**
	 * Método que convierte una lista de eventos del modelo a eventos entidad
	 * 
	 * @param me lista de eventos del modelo
	 * @return lista de eventos entidad
	 */
	public static List<Evento> listMEventoToEntity(List<MEvento> me) {
		List<Evento> eventos = new ArrayList<Evento>();
		for (MEvento mevento : me) {
			eventos.add(meventoToEntity(mevento));
		}
		return eventos;
	}

	/**
	 * Método que convierte una lista de eventos entidad a eventos del modelo
	 * 
	 * @param eventos lista de eventos entidad
	 * @return lista de eventos modelo
	 */
	public static List<MEvento> listEventoEntityToModel(List<Evento> eventos) {
		List<MEvento> meventos = new ArrayList<MEvento>();
		for (Evento evento : eventos) {
			meventos.add(eventoEntityToModel(evento));
		}
		return meventos;
	}

}
