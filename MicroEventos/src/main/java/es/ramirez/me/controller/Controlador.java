//package es.ramirez.me.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import es.ramirez.me.interfaces.IEvento;
//import es.ramirez.me.model.MEvento;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
///**
// * Controlador.java clase que responde a la interacción entre consumir el
// * servicio evento y las peticiones del modelo donde se gestiona el evento
// * 
// * @author Leyanis Ramírez
// * @version 1.0, 10/08/2021
// */
//@RestController
//@RequestMapping("/evento")
//@Api(value = "Evento Resource REST Endpoint", description = "Shows the evento info")
//public class Controlador {
//
//	@Autowired
//	IEvento ievento;
//
//	/**
//	 * Método que lista los eventos
//	 * 
//	 * @return ResponseEntity que contiene una lista de eventos y el código de
//	 *         estado del http
//	 */
//	@ApiOperation(value = "Método que lista los eventos")
//	@GetMapping("/findAll")
//	public ResponseEntity<List<MEvento>> findAll() {
//		return new ResponseEntity<List<MEvento>>(ievento.findAll(), HttpStatus.OK);
//	}
//
//	/**
//	 * Método que devuelve un evento dado su id
//	 * 
//	 * @param id del evento
//	 * @return ResponseEntity que contiene el evento encontrado y el código de
//	 *         estado del http
//	 */
//	@ApiOperation(value = "Método que devuelve un evento dado su id")
//	@GetMapping("/findById/{id}")
//	public ResponseEntity<MEvento> findById(@PathVariable("id") Integer id) {
//		return new ResponseEntity<MEvento>(ievento.findById(id), HttpStatus.OK);
//	}
//
//	/**
//	 * Método que crea un evento
//	 * 
//	 * @param mevento evento a crear
//	 * @return ResponseEntity que contiene un nuevo evento y el código de estado del
//	 *         http
//	 */
//	@PostMapping(value = "/crearEvento", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> crearEvento(@RequestBody MEvento mevento) {
//		ievento.crearEvento(mevento);
//		return ResponseEntity.ok("ok");
//	}

//}
