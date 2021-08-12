package com.lucaticket.usuarios.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucaticket.usuarios.model.dto.Usuario_DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 
 * Usuario
 * 
 * @author David
 * @version 1.0
 * @see 11/08/2021
 * @see Clase modelo que interacciona directamente con la base de datos
 *
 */
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_usuario;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String email;
	@Column
	private String contrasenia;
	@Column
	private Date fecha_alta;

	public Usuario(Usuario_DTO usuario_dto) {
		this.id_usuario = usuario_dto.getId_usuario();
		this.nombre = usuario_dto.getNombre();
		this.apellido = usuario_dto.getApellido();
		this.email = usuario_dto.getEmail();
		this.contrasenia = usuario_dto.getContrasenia();
		this.fecha_alta = usuario_dto.getFecha_alta();
	}

}
