package com.lucaticket.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucaticket.clientes.model.Cliente;

@Repository
/**
 * 
 * IClienteRepository
 * 
 * @author David
 * @version 1.0 
 * @see 19/08/2021 
 * @see Clase repositorio para conectar con la base de datos mediante Jpa
 *
 */
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
