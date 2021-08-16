package es.ramirez.me.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ramirez.me.interfaces.IEvento;
import es.ramirez.me.model.MEvento;
import es.ramirez.me.model.entities.Evento;
import es.ramirez.me.repository.EventoRepository;
import es.ramirez.me.util.Convertidor;

/**
 * EventoService.java clase que implementa las operaciones interfaz IEvento.java
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@Service
public class EventoService implements IEvento {
	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	EventoRepository eventoRepository;

	@Override
	public String crearEvento(MEvento me) {
		Evento evento = eventoRepository.findById(me.getId_evento()).orElse(null);
		if (evento != null) {
			log.error("El evento ya existe");
			return "error";
		} else {
			evento = new Evento();
			evento = Convertidor.meventoToEntity(me);
			evento = eventoRepository.save(evento);
			log.info("El evento se ha creado correctamente");
			return "ok";
		}
	}

	@Override
	public String editarEvento(MEvento me) {
		Evento evento = eventoRepository.findById(me.getId_evento()).orElse(null);
		if (evento == null) {
			log.error("El evento no existe");
			return "error";
		} else {
			evento.setId_evento(me.getId_evento());
			evento.setNombre(me.getNombre());
			evento.setDesc_corta(me.getDesc_corta());
			evento.setDesc_ext(me.getDesc_ext());
			evento.setFechaHora(me.getFechaHora());
			evento.setFoto(me.getFoto());
			evento.setGenero(me.getGenero());
			evento.setPolitica_acceso(me.getPolitica_acceso());
			evento.setPrecio(me.getPrecio());
			evento.setRecinto(Convertidor.mrecintoToEntity(me.getMrecinto()));
			evento = eventoRepository.save(evento);
			log.info("El evento se ha modificado correctamente");
			return "ok";
		}
	}

	@Override
	public String deleteById(int id) {
		Evento e = eventoRepository.findById(id).orElse(null);
		if (e == null) {
			log.error("El evento no existe");
			return "error";
		} else {
			eventoRepository.delete(e);
			log.info("El evento se ha eliminado correctamente");
			return "ok";
		}
	}

	@Override
	public MEvento findById(Integer id) {
		Evento evento = eventoRepository.findById(id).orElse(null);
		if (evento == null) {
			log.error("El evento no existe");
			return null;
		} else {
			log.info("Se ha encontrado el evento");
			return Convertidor.eventoEntityToModel(evento);
		}
	}

	@Override
	public List<MEvento> findAll() {
		log.info("Los eventos se han listado correctamente");
		return Convertidor.listEventoEntityToModel(eventoRepository.findAll());
	}

	@Override
	public List<MEvento> findByNombre(String nombre) {
		List<MEvento> lista = Convertidor.listEventoEntityToModel(eventoRepository.findAll());
		lista = lista.stream().filter(t -> t.getNombre().matches(".*" + nombre + ".*")).collect(Collectors.toList());
		return lista;
	}

	@Override
	public List<MEvento> findByCiudad(String ciudad) {
		List<MEvento> lista = Convertidor.listEventoEntityToModel(eventoRepository.findAll());
		lista = lista.stream().filter(t -> t.getMrecinto().getLugar().matches(".*" + ciudad + ".*"))
				.collect(Collectors.toList());
		return lista;
	}

	@Override
	public List<MEvento> findByTipoGenero(String tipoGenero) {
		List<MEvento> lista = Convertidor.listEventoEntityToModel(eventoRepository.findAll());
		lista = lista.stream().filter(t -> t.getGenero().matches(".*" + tipoGenero + ".*"))
				.collect(Collectors.toList());
		return lista;
	}

}
