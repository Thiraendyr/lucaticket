package es.bligor.mc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("MEvento")
public class Evento {

	private Integer id_evento;
	
	private Integer id_usuario;
	
	private String nombre;
	
	private String desc_corta;
	
	private String desc_ext;
	
	private String foto;
	
	private String genero;
	
	private Date fechaHora;
	
	private String politica_acceso;
	
	private Recinto mrecinto;
}
