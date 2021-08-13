package com.lucaticket.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucaticket.usuarios.model.Usuario;

@Repository
/**
 * 
 * IUsuarioRepository
 * 
 * @author David
 * @version 1.0 
 * @see 11/08/2021 
 * @see Clase repositorio para conectar con la base de datos mediante Jpa
 *
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByNombre(String nombre);

}
