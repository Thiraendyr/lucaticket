package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Venta;

@Service
public class VentaService {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://luca-ventas";
	private HttpHeaders headers = new HttpHeaders();

	public Venta add(Venta venta) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Venta> request = new HttpEntity<>(venta, headers);
		return restTemplate.postForObject(url + "/entrada/crearEntrada", request, Venta.class);
	}

	public void update(Venta venta) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Venta> request = new HttpEntity<>(venta, headers);
		restTemplate.put(url + "/entrada/editarEntrada", request);
	}

	public void delete(Integer id) {
		restTemplate.delete(url + "/entrada/borrarEntrada/" + id);
	}

	public List<Venta> getAll() {
		return Arrays.asList(restTemplate.getForObject(url + "/entrada/findAll",Venta[].class));
	}

	public Venta getById(Integer id) {
		return restTemplate.getForObject(url + "/entrada/findById/" + id, Venta.class);
	}

	public List<Venta> getByNombre(String nombre) {
		return Arrays.asList(restTemplate.getForObject(url + "/entrada/findByNombre/{nombre}", Venta[].class, nombre));
	}
	
	public List<Venta> getByTipo(String tipo) {
		return Arrays.asList(restTemplate.getForObject(url + "/entrada/findByTipo/{tipo}", Venta[].class, tipo));
	}
	
	public boolean getPagoTicket(int idEntrada) {
		return restTemplate.getForObject(url + "/entrada/pagoTicket/{idEntrada}", Boolean.class, idEntrada);
		
	}
}
