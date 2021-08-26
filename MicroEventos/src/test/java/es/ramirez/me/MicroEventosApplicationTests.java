package es.ramirez.me;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.ramirez.me.interfaces.IEvento;
import es.ramirez.me.model.MEvento;
import es.ramirez.me.model.MRecinto;

/**
 * MicroEventosApplicationTests.java clase para las pruebas unitarias
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 11/08/2021
 */
@SpringBootTest
class MicroEventosApplicationTests {

	@Autowired
	IEvento ievento;

	@Test
	void contextLoads() {

	}

	@Test
	public void crearEvento() {

		MEvento evento = new MEvento();

		evento.setId_evento(7);
		evento.setId_usuario(1);
		evento.setNombre("Curso de Docker");
		evento.setDesc_corta("Curso de Docker");
		evento.setDesc_ext("Curso de Docker para principiantes");
		evento.setFechaHora(new Date());
		evento.setFoto("");
		evento.setGenero("Jazz");
		evento.setPolitica_acceso("Solo personal autorizado");
		MRecinto mrecinto = new MRecinto();
		mrecinto.setId_recinto(3);
		mrecinto.setNombre("Aula Magna");
		mrecinto.setLugar("Madrid");
		mrecinto.setDireccion("Calle del Carmen");
		mrecinto.setAforo(96);
		evento.setMrecinto(mrecinto);

		String crear = ievento.crearEvento(evento);

		assertEquals("ok", crear);
	}

	@Test
	public void editarEvento() {
		MEvento evento = new MEvento();

		evento.setId_evento(7);
		evento.setNombre("Curso de Docker");
		evento.setDesc_corta("Curso de Docker");
		evento.setDesc_ext("Curso de Docker para principiantes");
		evento.setFechaHora(new Date());
		evento.setFoto("");
		evento.setGenero("Jazz");
		evento.setPolitica_acceso("Solo personal autorizado");
		MRecinto mrecinto = new MRecinto();
		mrecinto.setId_recinto(3);
		mrecinto.setNombre("Aula Magna");
		mrecinto.setLugar("Madrid");
		mrecinto.setDireccion("Calle del Carmen");
		mrecinto.setAforo(90);
		evento.setMrecinto(mrecinto);

		String editar = ievento.editarEvento(evento);
		assertNotEquals("error", editar);
	}

	@Test
	public void eliminarEvento() {

		String eliminar = ievento.deleteById(7);

		assertFalse("error".equalsIgnoreCase(eliminar));
	}

	@Test
	public void findAll() {
		assertTrue(!ievento.findAll().isEmpty());
	}

	@Test
	public void findById() {
		assertNotNull(ievento.findById(1));
	}

	@Test
	public void findByNombre() {
		assertFalse(ievento.findByNombre("Curso").isEmpty());
	}

	@Test
	public void findByCiudad() {
		assertTrue(!ievento.findByCiudad("Madrid").isEmpty());
	}

	@Test
	public void findByTipoGenero() {
		assertFalse(ievento.findByTipoGenero("Jazz").isEmpty());
	}

}
