package com.lucaticket.usuarios.controller;

import java.util.Date;
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

import com.lucaticket.usuarios.model.dto.Usuario_DTO;
import com.lucaticket.usuarios.service.IUsuarioService;
import com.lucaticket.usuarios.util.JsonUtilsCustom;
import com.lucaticket.usuarios.util.Operaciones;

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
	
	@Autowired
	private BCryptPasswordEncoder encoder;

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

	@GetMapping("/{idUsuario}")
	/**
	 * 
	 * Método que devuelve un usuario por el id que se le pasa
	 * 
	 * @param id del usuario buscado
	 * @return usuario buscado y httpsstatus
	 *
	 */
	public ResponseEntity<Usuario_DTO> getUsuarioById(@PathVariable("idUsuario") Integer idUsuario) {
		return new ResponseEntity<Usuario_DTO>(usuarioService.findUsuarioById(idUsuario), HttpStatus.OK);
	}

	@PostMapping("/crear")
	/**
	 * 
	 * Método que crea un usuario nuevo
	 * 
	 * @param usuario que se quiere crear
	 * @return usuario creado y httpsstatus
	 *
	 */
	public ResponseEntity<Usuario_DTO> postUsuario(@RequestBody String jsonUsuario) {
		Usuario_DTO usuario = JsonUtilsCustom.convertirJsonAUsuario(jsonUsuario);
		if (usuario != null) {
			if (usuario.getNombre() != null && usuario.getApellido() != null && usuario.getEmail() != null
					&& usuario.getContrasenia() != null) {
				if (usuario.getId_usuario() == null
						|| usuarioService.findUsuarioById(usuario.getId_usuario()).getId_usuario() == null) {
					if (usuario.getFecha_alta() == null) {
						usuario.setFecha_alta(new Date());
					}
					usuario.setContrasenia(encoder.encode(usuario.getContrasenia()));
					return new ResponseEntity<Usuario_DTO>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);

				} else {
					return new ResponseEntity<Usuario_DTO>(new Usuario_DTO(), HttpStatus.IM_USED);
				}

			}
		}

		return new ResponseEntity<Usuario_DTO>(new Usuario_DTO(), HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/modificar")
	/**
	 * 
	 * Método que actualiza un usuario
	 * 
	 * @param usuario que se quiere actualizar
	 * @return usuario actualizado y httpsstatus
	 *
	 */
	public ResponseEntity<Usuario_DTO> putUsuario(@RequestBody String jsonUsuario) {
		Usuario_DTO usuario = JsonUtilsCustom.convertirJsonAUsuario(jsonUsuario);
		if (usuario != null) {
			Usuario_DTO usuarioBD = usuarioService.findUsuarioById(usuario.getId_usuario());
			if (usuarioBD.getId_usuario() != null) {
				if(usuario.getContrasenia() == null) {
					usuario.setContrasenia(usuarioBD.getContrasenia());
				} else {
					usuario.setContrasenia(encoder.encode(usuario.getContrasenia()));
				}
				return new ResponseEntity<Usuario_DTO>(usuarioService.saveUsuario(Operaciones.parseoUsuario(usuario, usuarioBD)), HttpStatus.OK);

			} else {
				return new ResponseEntity<Usuario_DTO>(new Usuario_DTO(), HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Usuario_DTO>(new Usuario_DTO(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{idUsuario}")
	/**
	 * 
	 * Método que elimina un usuario por el id que se le pasa
	 * 
	 * @param id del usuario a eliminar
	 * @return httpsstatus
	 *
	 */
	public ResponseEntity deleteUsuarioById(@PathVariable("idUsuario") Integer idUsuario) {
		if (usuarioService.findUsuarioById(idUsuario).getId_usuario() != null) {
			usuarioService.removeUsuarioById(idUsuario);
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

}
