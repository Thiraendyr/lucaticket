package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Evento;

@Service
public class EventoService {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://luca-eventos";
	private HttpHeaders headers = new HttpHeaders();

	public Evento add(Evento evento) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Evento> request = new HttpEntity<>(evento, headers);
		return restTemplate.postForObject(url + "/evento/crearEvento", request, Evento.class);
	}

	public void update(Evento evento) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Evento> request = new HttpEntity<>(evento, headers);
		restTemplate.put(url + "/evento/editarEvento", request);
	}

	public void delete(Integer id) {
		restTemplate.delete(url + "/evento/borrarEvento/" + id);
	}

	public List<Evento> getAll() {
		return Arrays.asList(restTemplate.getForObject(url + "/evento/findAll", Evento[].class));
	}

	public Evento getById(Integer id) {
		return restTemplate.getForObject(url + "/evento/findById/" + id, Evento.class);
	}

	public List<Evento> getByNombre(String nombre) {
		return Arrays.asList(restTemplate.getForObject(url + "/evento/findByNombre/{nombre}", Evento[].class, nombre));
	}

	public List<Evento> getByCiudad(String ciudad) {
		return Arrays.asList(restTemplate.getForObject(url + "/evento/findByCiudad/{ciudad}", Evento[].class, ciudad));
	}

	public List<Evento> getByGenero(String genero) {
		return Arrays.asList(restTemplate.getForObject(url + "/evento/findByGenero/{genero}", Evento[].class, genero));
	}
}
