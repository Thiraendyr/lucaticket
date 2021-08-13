package com.lucaticket.usuarios.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucaticket.usuarios.model.dto.Usuario_DTO;
import com.lucaticket.usuarios.repository.IUsuarioRepository;
import com.lucaticket.usuarios.util.Convertidor;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private IUsuarioRepository usuarioRepos;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario_DTO usuario = Convertidor.convertirModel_Dto(usuarioRepos.findByNombre(username));
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		return new User(usuario.getNombre(), usuario.getContrasenia(), roles);
	}

}
