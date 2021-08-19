package com.lucaticket.clientes.service;

import java.util.List;

import com.lucaticket.clientes.model.dto.Cliente_DTO;

/**
 * 
 * IClienteService
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Interfaz servicio que contiene las operaciones que realizará el servicio
 *
 */
public interface IClienteService {

	List<Cliente_DTO> findAll();

	Cliente_DTO findById(int idCliente);

	Cliente_DTO save(Cliente_DTO cliente);

	void deleteById(int idCliente);

}
