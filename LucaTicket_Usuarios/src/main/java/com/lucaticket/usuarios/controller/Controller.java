package com.lucaticket.usuarios.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaticket.usuarios.model.dto.Usuario_DTO;
import com.lucaticket.usuarios.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
/**
 * 
 * Controller
 * 
 * @author David
 * @version 1.0
 * @see 11/08/2021
 * @see Clase controladora que expone servicios rest
 *
 */
public class Controller {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/all")
	/**
	 * 
	 * Método que devuelve una lista de todos los usuarios
	 * 
	 * @return lista de usuarios y httpsstatus
	 *
	 */
	public ResponseEntity<List<Usuario_DTO>> getAllUsuarios() {
		return new ResponseEntity<List<Usuario_DTO>>(usuarioService.findAllUsuarios(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	/**
	 * 
	 * Método que devuelve un usuario por el id que se le pasa
	 * 
	 * @param id del usuario buscado
	 * @return usuario buscado y httpsstatus
	 *
	 */
	public ResponseEntity<Usuario_DTO> getUsuarioById(@PathVariable("id") int id) {
		return new ResponseEntity<Usuario_DTO>(usuarioService.findUsuarioById(id), HttpStatus.OK);
	}

	@PostMapping("/new")
	/**
	 * 
	 * Método que crea un usuario nuevo
	 * 
	 * @param usuario que se quiere crear
	 * @return usuario creado y httpsstatus
	 *
	 */
	public ResponseEntity<Usuario_DTO> postUsuario(@RequestBody Usuario_DTO usuario) {
		return new ResponseEntity<Usuario_DTO>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	/**
	 * 
	 * Método que actualiza un usuario
	 * 
	 * @param usuario que se quiere actualizar
	 * @return usuario actualizado y httpsstatus
	 *
	 */
	public ResponseEntity<Usuario_DTO> putUsuario(@RequestBody Usuario_DTO usuario) {
		if (usuarioService.findUsuarioById(usuario.getId_usuario()).getId_usuario() != null) {
			return new ResponseEntity<Usuario_DTO>(usuarioService.saveUsuario(usuario), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Usuario_DTO>(new Usuario_DTO(), HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/delete/{id}")
	/**
	 * 
	 * Método que elimina un usuario por el id que se le pasa
	 * 
	 * @param id del usuario a eliminar
	 * @return httpsstatus
	 *
	 */
	public ResponseEntity deleteUsuarioById(@PathVariable("id") int id) {
		if (usuarioService.findUsuarioById(id).getId_usuario() != null) {
			usuarioService.removeUsuarioById(id);
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

}
