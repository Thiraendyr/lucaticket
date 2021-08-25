package es.ramirez.venta.banco;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


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
		ClientConfig clientConfig = new  DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(UPDATE_CLIENT_API);
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,cliente);
		int status = response.getStatus();
		return status;
	}


}
