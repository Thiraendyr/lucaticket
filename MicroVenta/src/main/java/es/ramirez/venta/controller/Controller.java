package es.ramirez.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.core.JsonProcessingException;

import es.ramirez.venta.interfaces.IEntrada;
import es.ramirez.venta.model.MEntrada;
import es.ramirez.venta.util.exception.ApiUnproccesableEntity;
import es.ramirez.venta.util.validation.EntradaValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller.java clase que responde a la interacción entre consumir el
 * servicio de entrada y las peticiones del modelo donde se gestiona las
 * entradas
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@RestController
@RequestMapping("/entrada")
@Api(tags = { "Entradas" }, value = "Entrada Resource REST Endpoint", description = "Muestra la información de la entrada")
public class Controller {
	@Autowired
	IEntrada ientrada;

	@Autowired
	EntradaValidator entradaValidator;

	/**
	 * Método que crea una entrada
	 * 
	 * @param mentrada entrada a crear
	 * @return ResponseEntity que contiene una nueva entrada
	 * @throws ApiUnproccesableEntity Excepcion para el estado 422
	 */
	@PostMapping(value = "/crearEntrada", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que crea una entrada", httpMethod = "POST", notes = "<br>Operación que crea una nueva entrada", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Successful operation"),
			@ApiResponse(code = 201, message = "Created", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> crearEntrada(@RequestBody MEntrada mentrada) throws ApiUnproccesableEntity {
		entradaValidator.validator(mentrada);
		String resultado = ientrada.crearEntrada(mentrada);
		return ResponseEntity.ok(resultado);
	}

	/**
	 * Método que modifica una entrada
	 * 
	 * @param mentrada una Entrada a modificar
	 * @return ResponseEntity que contiene una entrada modificada
	 * @throws ApiUnproccesableEntity Excepcion para el estado 422
	 */
	@PutMapping(value = "/editarEntrada", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que modifica una entrada", httpMethod = "PUT", notes = "<br>Operación que modifica una entrada", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Successful operation"),
			@ApiResponse(code = 201, message = "Created", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> editarEntrada(@RequestBody MEntrada mentrada) throws ApiUnproccesableEntity {
		entradaValidator.validator(mentrada);
		String resultado = ientrada.editarEntrada(mentrada);
		return ResponseEntity.ok(resultado);
	}

	/**
	 * Método que elimina una entrada dado un id
	 * 
	 * @param id de la entrada a eliminar
	 * @return ResponseEntity que con contiene un String que fue eliminada la
	 *         entrada
	 */
	@DeleteMapping(value = "/borrarEntrada/{id}")
	@ApiOperation(produces = "application/json", value = "Método que elimina una entrada dado un id", httpMethod = "DELETE", notes = "<br>Operación que elimina una entrada", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Successful operation"),
			@ApiResponse(code = 204, message = "No content", response = Error.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> borrarEntrada(
			@ApiParam(value = "Id del entrada", required = true) @PathVariable("id") int id) {
		String resultado = ientrada.deleteById(id);
		return ResponseEntity.ok(resultado);
	}

	/**
	 * Método que lista las entradas
	 * 
	 * @return ResponseEntity que contiene una lista de entradas
	 */
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que lista las entradas", httpMethod = "GET", notes = "<br>Operación que lista las entradas", response = MEntrada[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEntrada.class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.ok(ientrada.findAll());
	}

	/**
	 * Método que devuelve una entrada dado su id
	 * 
	 * @param id de la entrada
	 * @return ResponseEntity que contiene la entrada encontrado
	 */
	@GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve una entrada dado su id", httpMethod = "GET", notes = "<br>Operación que devuelve una entrada dado su id", response = MEntrada.class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEntrada.class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> findById(
			@ApiParam(value = "Id de la entrada", required = true) @PathVariable("id") Integer id) {
		return ResponseEntity.ok(ientrada.findById(id));
	}

	/**
	 * Método que devuelve una entrada dado su nombre
	 * 
	 * @param nombre de la entrada
	 * @return ResponseEntity que contiene una entrada encontrada
	 */
	@GetMapping(value = "/findByNombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve una entrada dado su nombre", httpMethod = "GET", notes = "<br>Operación que devuelve una entrada dado su nombre", response = MEntrada[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEntrada[].class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> findByNombre(
			@ApiParam(value = "nombre de la entrada", required = true) @PathVariable("nombre") String nombre) {
		return ResponseEntity.ok(ientrada.findByNombre(nombre));
	}

	/**
	 * Método que devuelve una entrada dado su tipo
	 * 
	 * @param tipo búsqueda por tipo de entrada
	 * @return ResponseEntity que contiene una entrada encontrada
	 */
	@GetMapping(value = "/findByTipo/{tipo}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que devuelve una entrada dado su tipo", httpMethod = "GET", notes = "<br>Operación que devuelve una entrada dado su tipo", response = MEntrada[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEntrada[].class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> findByTipo(
			@ApiParam(value = "tipo de entrada", required = true) @PathVariable("tipo") String tipo) {
		return ResponseEntity.ok(ientrada.findByTipo(tipo));
	}

	/**
	 * Método que realiza la reserva de una entrada
	 * @param idEntrada identificador de la entrada
	 * @return si fue reservada o no la entrada
	 * @throws JsonProcessingException Excepcion para procesar un json
	 */
	@GetMapping(value = "/pagoTickect/{idEntrada}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(produces = "application/json", value = "Método que realiza la reserva de la entrada", httpMethod = "GET", notes = "<br>Operación que devuelve true si se ha realizado la reserva correctamente", response = MEntrada[].class)
	@ApiResponses(value = { @ApiResponse(code = 200, response = MEntrada[].class, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 422, message = "Invalid data", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public ResponseEntity<Object> getPagoTickest(
			@ApiParam(value = "id de la entrada", required = true) @PathVariable("idEntrada") Integer idEntrada)
			throws JsonProcessingException {
		return ResponseEntity.ok(ientrada.pagoTickest(idEntrada));
	}
}
