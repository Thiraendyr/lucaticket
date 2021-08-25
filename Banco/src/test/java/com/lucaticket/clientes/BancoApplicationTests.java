package com.lucaticket.clientes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
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

import com.lucaticket.clientes.model.Cliente;
import com.lucaticket.clientes.repository.IClienteRepository;
import com.lucaticket.clientes.util.Operaciones;

@RunWith(SpringRunner.class)
@SpringBootTest
class BancoApplicationTests {

	@Autowired
	private IClienteRepository repos;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		System.out.println(Operaciones.numeroAleatorio(22));
	}

	@Test
	@Rollback
	public void crearClienteTest() {
		Cliente cli = new Cliente();
		cli.setIdCliente(0);
		cli.setNombre("David");
		cli.setApellido("Talavera");
		cli.setContrasenia(encoder.encode("123456"));
		cli.setNumeroCuenta("ES" + Operaciones.numeroAleatorio(22));
		cli.setSaldo(500.0);
		

		Cliente ret = repos.save(cli);

		assertTrue(ret.getContrasenia().equalsIgnoreCase(cli.getContrasenia()));

	}

	@Test
	public void findAllTest() {
		List<Cliente> clis = repos.findAll();

		assertThat(clis).size().isGreaterThan(0);
	}

	@Test
	public void findClienteByIdTest() {
		Cliente ret = new Cliente();
		
		for (Cliente cli : repos.findAll()) {
			repos.findById(cli.getIdCliente()).get();
			break;
		}
		
		assertNotNull(ret);
	}

	@Test
	@Rollback
	public void putClienteTest() {		
		Cliente cli = new Cliente();
		
		for (Cliente cliLoop : repos.findAll()) {
			cli = repos.findById(cliLoop.getIdCliente()).get();
			break;
		}

		cli.setNombre("Pepe");

		Cliente ret = repos.save(cli);

		assertTrue(cli.getNombre().equals(ret.getNombre()));

	}

	@Test
	@Rollback
	public void deleteClienteTest() {
		for (Cliente cli : repos.findAll()) {
			repos.deleteById(cli.getIdCliente());
		}

	}

}
