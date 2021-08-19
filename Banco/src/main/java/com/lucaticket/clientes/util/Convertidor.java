package com.lucaticket.clientes.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lucaticket.clientes.model.Cliente;
import com.lucaticket.clientes.model.dto.Cliente_DTO;

/**
 * 
 * Convertidor
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Clase para convertir objetos entre clase modelo y dto
 *
 */
public class Convertidor {

	/**
	 * Método que devuelve una lista convertida de modelo a dto
	 * 
	 * @param lista de clientes de la clase modelo
	 * @return lista de clientes de la clase dto
	 */
	public static List<Cliente_DTO> convertirLista(List<Cliente> clientes) {
		return clientes.stream().map(Cliente_DTO::new).collect(Collectors.toList());

	}

	/**
	 * Método que devuelve un cliente convertido de dto a modelo
	 * 
	 * @param cliente de la clase dto
	 * @return cliente de la clase modelo
	 */
	public static Cliente convertirDto_Model(Cliente_DTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(clienteDTO.getIdCliente());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellido(clienteDTO.getApellido());
		cliente.setSaldo(clienteDTO.getSaldo());
		cliente.setContrasenia(clienteDTO.getContrasenia());
		cliente.setNumeroCuenta(clienteDTO.getNumeroCuenta());
		return cliente;

	}

	/**
	 * Método que devuelve un cliente convertido de modelo a dto
	 * 
	 * @param cliente de la clase modelo
	 * @return cliente de la clase dto
	 */
	public static Cliente_DTO convertirModel_Dto(Cliente cliente) {
		Cliente_DTO clienteDTO = new Cliente_DTO();
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellido(cliente.getApellido());
		clienteDTO.setSaldo(cliente.getSaldo());
		clienteDTO.setContrasenia(cliente.getContrasenia());
		clienteDTO.setNumeroCuenta(cliente.getNumeroCuenta());
		return clienteDTO;
	}

}
