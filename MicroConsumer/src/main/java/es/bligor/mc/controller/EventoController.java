package es.bligor.mc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.bligor.mc.entity.Evento;
import es.bligor.mc.kafka.Producer;
import es.bligor.mc.service.EmailService;
import es.bligor.mc.service.EventoService;

@RestController
public class EventoController{

	@Autowired
	private EventoService eventoService;
	
	@Autowired
	Producer producer;
	
	@PostMapping("/evento")
	public ResponseEntity<Evento> add(@RequestBody Evento evento) throws IOException {
		producer.sendMensaje(String.valueOf(evento.getId_evento()));
		Evento e = eventoService.add(evento);
		return new ResponseEntity<Evento>(e, HttpStatus.OK);
	}

	@PutMapping("/evento")
	public ResponseEntity<String> update(@RequestBody Evento evento) {
		eventoService.update(evento);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping("/evento/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		eventoService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/evento/findAll")
	public ResponseEntity<List<Evento>> getAll() {
		return new ResponseEntity<List<Evento>>(eventoService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/evento/{id}")
	public ResponseEntity<Evento> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Evento>(eventoService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/evento/filtroNombre/{nombre}")
	public ResponseEntity<List<Evento>> getByNombre(@PathVariable("nombre") String nombre) {
		return new ResponseEntity<List<Evento>>(eventoService.getByNombre(nombre), HttpStatus.OK);
	}
	
	@GetMapping("/evento/filtroCiudad/{ciudad}")
	public ResponseEntity<List<Evento>> getByCiudad(@PathVariable("ciudad") String ciudad) {
		return new ResponseEntity<List<Evento>>(eventoService.getByCiudad(ciudad), HttpStatus.OK);
	}
	
	@GetMapping("/evento/filtroGenero/{genero}")
	public ResponseEntity<List<Evento>> getByGenero(@PathVariable("genero") String genero) {
		return new ResponseEntity<List<Evento>>(eventoService.getByGenero(genero), HttpStatus.OK);
	}
	
	/******************************* EMAIL *******************************/
	@Autowired
	EmailService eService;

	@GetMapping("/evento/email")
	public void email() {
		
		eService.sendSimpleMessage("leyanis.ramirez@luca-tic.com", "SubjectPrueba", "TextPrueba");
	}


}
