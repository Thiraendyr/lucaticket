package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://luca-usuarios";
	
	public List<Usuario> getUsuarios() {
		
		return Arrays.asList(restTemplate.getForObject(url + "/usuario/all",Usuario[].class));
	}

	public Usuario getById(Integer id) {
		return restTemplate.getForObject(url + "/usuario/" + id, Usuario.class);
	}
}
