package com.lucaticket.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaticket.clientes.model.dto.Cliente_DTO;
import com.lucaticket.clientes.service.IClienteService;
import com.lucaticket.clientes.util.JsonUtilsCustom;
import com.lucaticket.clientes.util.Operaciones;

@RestController
@RequestMapping("/banco/cliente")
/**
 * 
 * Controller
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Clase controladora que expone servicios rest
 *
 */
public class Controller {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/all")
	/**
	 * 
	 * Método que devuelve una lista de todos los clientes
	 * 
	 * @return lista de clientes y httpsstatus
	 *
	 */
	public ResponseEntity<List<Cliente_DTO>> getAllClientes() {
		return new ResponseEntity<List<Cliente_DTO>>(clienteService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{idCliente}")
	/**
	 * 
	 * Método que devuelve un cliente por el id que se le pasa
	 * 
	 * @param id del cliente buscado
	 * @return cliente buscado y httpsstatus
	 *
	 */
	public ResponseEntity<Cliente_DTO> getClienteById(@PathVariable("idCliente") Integer idCliente) {
		return new ResponseEntity<Cliente_DTO>(clienteService.findById(idCliente), HttpStatus.OK);
	}

	@PostMapping("/crear")
	/**
	 * 
	 * Método que crea un cliente nuevo
	 * 
	 * @param cliente que se quiere crear
	 * @return cliente creado y httpsstatus
	 *
	 */
	public ResponseEntity<Cliente_DTO> postCliente(@RequestBody String jsoncliente) {
		Cliente_DTO cliente = JsonUtilsCustom.convertirJsonACliente(jsoncliente);
		if (cliente != null) {
			if (cliente.getNombre() != null && cliente.getApellido() != null && cliente.getContrasenia() != null) {
				if (cliente.getIdCliente() == null
						|| clienteService.findById(cliente.getIdCliente()).getIdCliente() == null) {
					if (cliente.getNumeroCuenta() == null) {
						cliente.setNumeroCuenta("ES" + Operaciones.numeroAleatorio(22));
					}
					cliente.setContrasenia(encoder.encode(cliente.getContrasenia()));
					return new ResponseEntity<Cliente_DTO>(clienteService.save(cliente), HttpStatus.CREATED);

				} else {
					return new ResponseEntity<Cliente_DTO>(new Cliente_DTO(), HttpStatus.IM_USED);
				}

			}
		}

		return new ResponseEntity<Cliente_DTO>(new Cliente_DTO(), HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/modificar")
	/**
	 * 
	 * Método que actualiza un cliente
	 * 
	 * @param cliente que se quiere actualizar
	 * @return cliente actualizado y httpsstatus
	 *
	 */
	public ResponseEntity<Cliente_DTO> putCliente(@RequestBody String jsoncliente) {
		Cliente_DTO cliente = JsonUtilsCustom.convertirJsonACliente(jsoncliente);
		if (cliente != null) {
			Cliente_DTO clienteBD = clienteService.findById(cliente.getIdCliente());
			if (clienteBD.getIdCliente() != null) {
				if (cliente.getSaldo() >= 0) {
					if (cliente.getContrasenia() == null) {
						cliente.setContrasenia(clienteBD.getContrasenia());
					} else {
						cliente.setContrasenia(encoder.encode(cliente.getContrasenia()));
					}
					return new ResponseEntity<Cliente_DTO>(
							clienteService.save(Operaciones.parseoCliente(cliente, clienteBD)), HttpStatus.OK);
				} else {
					return new ResponseEntity<Cliente_DTO>(new Cliente_DTO(), HttpStatus.NOT_ACCEPTABLE);
				}

			} else {
				return new ResponseEntity<Cliente_DTO>(new Cliente_DTO(), HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Cliente_DTO>(new Cliente_DTO(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{idCliente}")
	/**
	 * 
	 * Método que elimina un cliente por el id que se le pasa
	 * 
	 * @param id del cliente a eliminar
	 * @return httpsstatus
	 *
	 */
	public ResponseEntity deleteClienteById(@PathVariable("idCliente") Integer idCliente) {
		if (clienteService.findById(idCliente).getIdCliente() != null) {
			clienteService.deleteById(idCliente);
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

}
