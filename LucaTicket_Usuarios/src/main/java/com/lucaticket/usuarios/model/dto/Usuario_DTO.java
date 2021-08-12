package com.lucaticket.usuarios.model.dto;

import java.util.Date;

import com.lucaticket.usuarios.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 
 * Usuario_DTO
 * 
 * @author David
 * @version 1.0 
 * @see 11/08/2021 
 * @see Clase usada para no interactuar con la base de datos
 *
 */
public class Usuario_DTO {
	private Integer id_usuario;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private Date fecha_alta;
	
	public Usuario_DTO(Usuario usuario) {
		this.id_usuario = usuario.getId_usuario();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
		this.contrasenia = usuario.getContrasenia();
		this.fecha_alta = usuario.getFecha_alta();
	}
}
