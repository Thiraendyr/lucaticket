package es.ramirez.venta.banco;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * BancoService.java clase para acceder al servicio del banco
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Service
public class BancoService {

	private static final String UPDATE_CLIENT_API = "http://localhost:2223/banco/cliente/modificar";
	private static final String FIND_CLIENT_API = "http://localhost:2223/banco/cliente/";

	/**
	 * Método que accede a la búsqueda de un cliente dado su id
	 * 
	 * @param idCliente identificador del cliente
	 * @return cliente
	 */
	public Cliente getClienteById(int idCliente) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(FIND_CLIENT_API + idCliente, Cliente.class);
	}

	/**
	 * Método que acceda al método putCliente
	 * 
	 * @param cliente json con los datos del cliente
	 * @return número con el estado del código
	 */
	public int getJsonCliente(String cliente) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(cliente, headers);

		restTemplate.put(UPDATE_CLIENT_API, request);

		return new ResponseEntity<String>(HttpStatus.OK).getStatusCodeValue();

	}

}
