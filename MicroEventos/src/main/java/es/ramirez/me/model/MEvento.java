package es.ramirez.me.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MEvento.java clase que representa un evento pero que no tiene interacción con
 * la base de datos.
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Evento bean")
public class MEvento {

	@ApiModelProperty(value = "id_evento identificador de un evento")
	private Integer id_evento;
	@ApiModelProperty(value = "id_usuario identificador del usuario que creará el evento")
	private Integer id_usuario;
	@ApiModelProperty(value = "nombre de evento")
	private String nombre;
	@ApiModelProperty(value = "descripción corta de un evento")
	private String desc_corta;
	@ApiModelProperty(value = "descripción larga de un evento")
	private String desc_ext;
	@ApiModelProperty(value = "foto de un evento")
	private String foto;
	@ApiModelProperty(value = "contenido a tratar en el evento")
	private String genero;
	@ApiModelProperty(value = "fecha y hora de celebración de un evento")
	private Date fechaHora;
	@ApiModelProperty(value = "coste de un evento")
	private Double precio;
	@ApiModelProperty(value = "autorización para acceder a un evento")
	private String politica_acceso;
	@ApiModelProperty(value = "local donde se va a celebrar un evento")
	private MRecinto mrecinto;
}
