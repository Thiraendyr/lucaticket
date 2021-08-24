package com.lucaticket.usuarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaticket.usuarios.model.Usuario;
import com.lucaticket.usuarios.model.dto.Usuario_DTO;
import com.lucaticket.usuarios.repository.IUsuarioRepository;
import com.lucaticket.usuarios.service.IUsuarioService;
import com.lucaticket.usuarios.util.Convertidor;

@Service
/**
 * 
 * UsuarioServiceImpl
 * 
 * @author David
 * @version 1.0
 * @see 11/08/2021
 * @see Clase servicio para hacer operaciones con la base de datos
 *
 */
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	/**
	 * Método que devuelve una lista de usuarios
	 * 
	 * @return lista de usuarios
	 */
	public List<Usuario_DTO> findAllUsuarios() {
		return Convertidor.convertirLista(usuarioRepository.findAll());
	}

	@Override
	/**
	 * Método que devuelve un usuario por el id que se le pasa
	 * 
	 * @param id_usuario que se desea recuperar
	 * @return usuario buscado
	 */
	public Usuario_DTO findUsuarioById(Integer id_usuario) {
		return Convertidor.convertirModel_Dto(usuarioRepository.findById(id_usuario).orElse(new Usuario()));
	}

	@Override
	/**
	 * Método que guarda(crea/actualiza) un usuario en la base de datos
	 * 
	 * @param usuario para guardar
	 * @return usuario guardado
	 */
	public Usuario_DTO saveUsuario(Usuario_DTO usuario_dto) {
		return Convertidor.convertirModel_Dto(usuarioRepository.save(Convertidor.convertirDto_Model(usuario_dto)));
	}

	@Override
	/**
	 * Método que elimina un usuario por el id que se le pasa
	 * 
	 * @param id_usuario que se desea eliminar
	 */
	public void removeUsuarioById(Integer id_usuario) {
		usuarioRepository.deleteById(id_usuario);
	}

}
