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
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Service
public class BancoService {
	
	private static final String UPDATE_CLIENT_API = "http://localhost:2223/banco/cliente/modificar";
	private static final String FIND_CLIENT_API = "http://localhost:2223/banco/cliente/";

	public Cliente getClienteById(int idCliente) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(FIND_CLIENT_API + idCliente, Cliente.class);
	}

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
