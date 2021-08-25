package com.lucaticket.usuarios.service;

import java.util.List;

import com.lucaticket.usuarios.model.dto.Usuario_DTO;

/**
 * 
 * IUsuarioService
 * 
 * @author David
 * @version 1.0
 * @see 11/08/2021
 * @see Interfaz servicio que contiene las operaciones que realizará el servicio
 *
 */
public interface IUsuarioService {
	List<Usuario_DTO> findAllUsuarios();

	Usuario_DTO findUsuarioById(Integer id_usuario);

	Usuario_DTO saveUsuario(Usuario_DTO usuario_dto);

	void removeUsuarioById(Integer id_usuario);
}
