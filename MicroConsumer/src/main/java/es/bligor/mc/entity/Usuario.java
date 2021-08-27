package es.bligor.mc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Usuario_DTO")
public class Usuario {

	private Integer id_usuario;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private Date fecha_alta;
}
