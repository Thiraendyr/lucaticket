package com.lucaticket.usuarios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucaticket.usuarios.model.Usuario;
import com.lucaticket.usuarios.repository.IUsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsuariosApplicationTests {
	
	@Autowired
	private IUsuarioRepository usuarioRepos;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario usu = new Usuario();
		usu.setId_usuario(0);
		usu.setNombre("David");
		usu.setApellido("Talavera");
		usu.setContrasenia(encoder.encode("123456"));
		usu.setEmail("davidtalaverab97@gmail.com");
		usu.setFecha_alta(new Date());
		
		Usuario ret = usuarioRepos.save(usu);
		
		assertTrue(ret.getContrasenia().equalsIgnoreCase(usu.getContrasenia()));
		
	}

	

}
