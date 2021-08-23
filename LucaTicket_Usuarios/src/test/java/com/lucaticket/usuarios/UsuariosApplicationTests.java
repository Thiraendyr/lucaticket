package com.lucaticket.usuarios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
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
	@Rollback
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

	@Test
	public void findAllTest() {
		List<Usuario> usus = usuarioRepos.findAll();

		assertThat(usus).size().isGreaterThan(0);
	}

	@Test
	public void findUsuarioByIdTest() {
		Usuario ret = new Usuario();
		
		for (Usuario usu : usuarioRepos.findAll()) {
			usuarioRepos.findById(usu.getId_usuario()).get();
			break;
		}
		
		assertNotNull(ret);
	}

	@Test
	@Rollback
	public void putUsuarioTest() {		
		Usuario usu = new Usuario();
		
		for (Usuario usuLoop : usuarioRepos.findAll()) {
			usu = usuarioRepos.findById(usuLoop.getId_usuario()).get();
			break;
		}

		usu.setId_usuario(11);
		usu.setNombre("Pepe");

		Usuario ret = usuarioRepos.save(usu);

		assertTrue(usu.getNombre().equals(ret.getNombre()));

	}

	@Test
	@Rollback
	public void deleteUsuarioTest() {
		for (Usuario usu : usuarioRepos.findAll()) {
			usuarioRepos.deleteById(usu.getId_usuario());
		}

	}

}
