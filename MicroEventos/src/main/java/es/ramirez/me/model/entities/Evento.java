package es.ramirez.me.model.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Evento.java colección en la que está almacenado el documento que representa a
 * la entidad evento
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@Document(collection = "evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * id_evento identificador de un evento
	 */
	@Id
	private Integer id_evento;
	/**
	 * nombre de evento
	 */
	private String nombre;
	/**
	 * descripción corta de un evento
	 */
	private String desc_corta;
	/**
	 * descripción larga de un evento
	 */
	private String desc_ext;
	/**
	 * foto de un evento
	 */
	private String foto;
	/**
	 * contenido a tratar en el evento
	 */
	private String genero;
	/**
	 * fecha y hora de celebración de un evento
	 */
	private Date fechaHora;
	/**
	 * coste de un evento
	 */
	private Double precio;
	/**
	 * autorización para acceder a un evento
	 */
	private String politica_acceso;
	/**
	 * local donde se va a celebrar un evento
	 */
	@NonNull
	private Recinto recinto;

}
