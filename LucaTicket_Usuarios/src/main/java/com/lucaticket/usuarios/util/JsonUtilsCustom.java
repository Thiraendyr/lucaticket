package com.lucaticket.usuarios.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucaticket.usuarios.model.dto.Usuario_DTO;
/**
 * 
 * JsonUtilsCustom
 * 
 * @author David
 * @version 1.0
 * @see 12/08/2021
 * @see Clase de utilidades para manipular json
 *
 */
public class JsonUtilsCustom {

	/**
	 * Método que valida si un json está correctamente estructurado
	 * 
	 * @param json
	 * @return true en caso de estar bien, false en caso de no estarlo
	 */
	public static boolean validarJson(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(json);
			return true;

		} catch (IOException e) {
			return false;
		}

	}

	/**
	 * Método que convierte un objecto json a usuario, en caso de estar algo mal devuelve null
	 * 
	 * @param json
	 * @return usuario
	 */
	public static Usuario_DTO convertirJsonAUsuario(String json) {
		if (validarJson(json)) {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				Usuario_DTO usuario = mapper.readValue(json, Usuario_DTO.class);
				
				return usuario;
				
			} catch (JsonMappingException e) {
			} catch (JsonProcessingException e) {
			}
			
			return null;
			
		} else {
			return null;
		}
	}

}
