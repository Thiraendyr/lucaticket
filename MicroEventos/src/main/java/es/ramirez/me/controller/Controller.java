package es.ramirez.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ramirez.me.interfaces.IEvento;
import es.ramirez.me.model.MEvento;
import es.ramirez.me.util.exception.ApiUnproccesableEntity;
import es.ramirez.me.util.validation.EventoValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller.java clase que responde a la interacción entre consumir el
 * servicio evento y las peticiones del modelo donde se gestiona el evento
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@RestController
@RequestMapping("/evento")
@Api(tags = { "Eventos" }, value = "Evento Resource REST Endpoint", description = "Muestra la información del evento")
public class Controller {
	@Autowired
	IEvento ievento;

	@Autowired
	EventoValidator eventov;

	/**
	 * Método que crea un evento
	 * 
	 * @param mevento evento a crear
	 * @return ResponseEntity que contiene un nuevo eventoF
	 * @throws ApiUnproccesableEntity Excepcion para el estado 422
	 */
	@PostMapping(value = "/crearEvento", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que crea un evento", httpMethod = "POST", notes = "<br>Operación que crea un nuevo evento", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Successful operation"),
			@ApiResponse(code = 201, message = "Created", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<MEvento> crearEvento(@RequestBody MEvento mevento) throws ApiUnproccesableEntity {
		eventov.validator(mevento);
		String resultado = ievento.crearEvento(mevento);
		if (resultado.equals("ok")) {
			return new ResponseEntity<MEvento>(mevento, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Método que modifica un evento
	 * 
	 * @param mevento un Evento a modificar
	 * @return ResponseEntity que contiene un evento modificado
	 * @throws ApiUnproccesableEntity Excepcion para el estado 422
	 */
	@PutMapping(value = "/editarEvento", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que modifica un evento", httpMethod = "PUT", notes = "<br>Operación que modifica un evento", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Successful operation"),
			@ApiResponse(code = 201, message = "Created", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<MEvento> editarEvento(@RequestBody MEvento mevento) throws ApiUnproccesableEntity {
		eventov.validator(mevento);
		String resultado = ievento.editarEvento(mevento);
		if (resultado.equals("ok")) {
			return new ResponseEntity<MEvento>(mevento, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Método que elimina un evento dado un id
	 * 
	 * @param id del evento a eliminar
	 * @return ResponseEntity que con contiene un String que fue eliminado el evento
	 */
	@DeleteMapping(value = "/borrarEvento/{id}")
	@ApiOperation(produces = "application/json", value = "Método que elimina un evento dado un id", httpMethod = "DELETE", notes = "<br>Operación que elimina un evento", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Successful operation"),
			@ApiResponse(code = 204, message = "No content", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<String> borrarEvento(
			@ApiParam(value = "Id del evento", required = true) @PathVariable("id") Integer id) {
		String resultado = ievento.deleteById(id);
		if (resultado.equals("ok")) {
			return new ResponseEntity<String>("Borrado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No existe", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Método que lista los eventos
	 * 
	 * @return ResponseEntity que contiene una lista de eventos
	 */
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que lista los eventos", httpMethod = "GET", notes = "<br>Operación que lista los eventos", response = MEvento[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEvento.class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<List<MEvento>> findAll() {
		return new ResponseEntity<List<MEvento>>(ievento.findAll(), HttpStatus.OK);
	}

	/**
	 * Método que devuelve un evento dado su id
	 * 
	 * @param id del evento
	 * @return ResponseEntity que contiene el evento encontrado
	 */
	@GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve un evento dado su id", httpMethod = "GET", notes = "<br>Operación que devuelve un evento dado su id", response = MEvento.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEvento.class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<MEvento> findById(
			@ApiParam(value = "Id del evento", required = true) @PathVariable("id") Integer id) {
		return new ResponseEntity<MEvento>(ievento.findById(id), HttpStatus.OK);
	}

	/**
	 * Método que devuelve un evento dado su nombre
	 * 
	 * @param nombre del evento
	 * @return ResponseEntity que contiene un evento encontrado
	 */
	@GetMapping(value = "/findByNombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve un evento dado su nombre", httpMethod = "GET", notes = "<br>Operación que devuelve un evento dado su nombre", response = MEvento[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEvento[].class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<List<MEvento>> findByNombre(
			@ApiParam(value = "nombre del evento", required = true) @PathVariable("nombre") String nombre) {
		return new ResponseEntity<List<MEvento>>(ievento.findByNombre(nombre), HttpStatus.OK);
	}

	/**
	 * Método que devuelve un evento dado el lugar de celebración
	 * 
	 * @param ciudad que representa el lugar de celebración del evento
	 * @return ResponseEntity que contiene un evento encontrado
	 */
	@GetMapping(value = "/findByCiudad/{ciudad}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve un evento dado el lugar de celebración", httpMethod = "GET", notes = "<br>Operación que devuelve un evento dado el lugar de celebración", response = MEvento[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEvento[].class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<List<MEvento>> findByCiudad(
			@ApiParam(value = "ciudad del evento", required = true) @PathVariable("ciudad") String ciudad) {
		return new ResponseEntity<List<MEvento>>(ievento.findByCiudad(ciudad), HttpStatus.OK);
	}

	/**
	 * Método que devuelve un evento dado su género
	 * 
	 * @param genero busqueda por genero
	 * @return ResponseEntity que contiene un evento encontrado
	 */
	@GetMapping(value = "/findByGenero/{genero}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve un evento dado su género", httpMethod = "GET", notes = "<br>Operación que devuelve un evento dado su género", response = MEvento[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEvento[].class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<List<MEvento>> findByGenero(
			@ApiParam(value = "género del evento", required = true) @PathVariable("genero") String genero) {
		return new ResponseEntity<List<MEvento>>(ievento.findByTipoGenero(genero), HttpStatus.OK);
	}
}
