package com.lucaticket.clientes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaticket.clientes.model.Cliente;
import com.lucaticket.clientes.model.dto.Cliente_DTO;
import com.lucaticket.clientes.repository.IClienteRepository;
import com.lucaticket.clientes.service.IClienteService;
import com.lucaticket.clientes.util.Convertidor;

@Service
/**
 * 
 * ClienteServiceImpl
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Clase servicio para hacer operaciones con la base de datos
 *
 */
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepository repos;

	@Override
	/**
	 * Método que devuelve una lista de clientes
	 * 
	 * @return lista de clientes
	 */
	public List<Cliente_DTO> findAll() {
		return Convertidor.convertirLista(repos.findAll());
	}

	@Override
	/**
	 * Método que devuelve un cliente por el id que se le pasa
	 * 
	 * @param id que se desea recuperar
	 * @return cliente buscado
	 */
	public Cliente_DTO findById(Integer idCliente) {
		return Convertidor.convertirModel_Dto(repos.findById(idCliente).orElse(new Cliente()));
	}

	@Override
	/**
	 * Método que guarda(crea/actualiza) un cliente en la base de datos
	 * 
	 * @param cliente para guardar
	 * @return cliente guardado
	 */
	public Cliente_DTO save(Cliente_DTO cliente) {
		return Convertidor.convertirModel_Dto(repos.save(Convertidor.convertirDto_Model(cliente)));
	}

	@Override
	/**
	 * Método que elimina un cliente por el id que se le pasa
	 * 
	 * @param id que se desea eliminar
	 */
	public void deleteById(Integer idCliente) {
		repos.deleteById(idCliente);		
	}

}
