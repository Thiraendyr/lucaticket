package com.lucaticket.usuarios.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lucaticket.usuarios.model.Usuario;
import com.lucaticket.usuarios.model.dto.Usuario_DTO;

/**
 * 
 * Convertidor
 * 
 * @author David
 * @version 1.0
 * @see 11/08/2021
 * @see Clase para convertir objetos entre clase modelo y dto
 *
 */
public class Convertidor {

	/**
	 * Método que devuelve una lista convertida de modelo a dto
	 * 
	 * @param lista de usuarios de la clase modelo
	 * @return lista de usuarios de la clase dto
	 */
	public static List<Usuario_DTO> convertirLista(List<Usuario> usuarios) {
		return usuarios.stream().map(Usuario_DTO::new).collect(Collectors.toList());

	}

	/**
	 * Método que devuelve un usuario convertido de dto a modelo
	 * 
	 * @param usuario de la clase dto
	 * @return usuario de la clase modelo
	 */
	public static Usuario convertirDto_Model(Usuario_DTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId_usuario(usuarioDTO.getId_usuario());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellido(usuarioDTO.getApellido());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setContrasenia(usuarioDTO.getContrasenia());
		usuario.setFecha_alta(usuarioDTO.getFecha_alta());
		return usuario;

	}

	/**
	 * Método que devuelve un usuario convertido de modelo a dto
	 * 
	 * @param usuario de la clase modelo
	 * @return usuario de la clase dto
	 */
	public static Usuario_DTO convertirModel_Dto(Usuario usuario) {
		Usuario_DTO usuarioDTO = new Usuario_DTO();
		usuarioDTO.setId_usuario(usuario.getId_usuario());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellido(usuario.getApellido());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setContrasenia(usuario.getContrasenia());
		usuarioDTO.setFecha_alta(usuario.getFecha_alta());
		return usuarioDTO;
	}

}
