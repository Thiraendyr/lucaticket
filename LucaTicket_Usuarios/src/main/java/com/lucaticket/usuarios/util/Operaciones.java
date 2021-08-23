package com.lucaticket.usuarios.util;

import com.lucaticket.usuarios.model.dto.Usuario_DTO;

/**
 * 
 * Operaciones
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Clase util que contiene operaciones
 *
 */
public class Operaciones {
	
	/**
	 * Método que mezcla datos de un usuario en caso de haber campos vacíos
	 * 
	 * @param usuario que puede contener campos vacíos, usuario de la base de datos
	 * @return usuario completo
	 */
	public static Usuario_DTO parseoUsuario(Usuario_DTO usuarioEntrada, Usuario_DTO usuarioBD) {
		Usuario_DTO usuario = usuarioEntrada;
		if(usuarioEntrada.getNombre() == null) 
			usuario.setNombre(usuarioBD.getNombre());
		if(usuarioEntrada.getApellido() == null) 
			usuario.setApellido(usuarioBD.getApellido());
		if(usuarioEntrada.getContrasenia() == null) 
			usuario.setContrasenia(usuarioBD.getContrasenia());
		if(usuarioEntrada.getEmail() == null) 
			usuario.setEmail(usuarioBD.getEmail());
		if(usuarioEntrada.getFecha_alta() == null) 
			usuario.setFecha_alta(usuarioBD.getFecha_alta());
		return usuario;
	}
}
