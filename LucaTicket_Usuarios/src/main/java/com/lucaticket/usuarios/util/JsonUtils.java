package com.lucaticket.usuarios.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static boolean jsonValido(String json) {
	    try {
	       final ObjectMapper mapper = new ObjectMapper();
	       mapper.readTree(json);
	       return true;
	    } catch (IOException e) {
	       return false;
	    }
	  }
	
}
