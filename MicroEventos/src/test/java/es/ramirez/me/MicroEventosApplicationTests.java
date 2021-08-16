package es.ramirez.me;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.ramirez.me.interfaces.IEvento;
import es.ramirez.me.model.MEvento;
import es.ramirez.me.model.MRecinto;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
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
		evento.setNombre("Curso de Docker");
		evento.setDesc_corta("Curso de Docker");
		evento.setDesc_ext("Curso de Docker para principiantes");
		evento.setFechaHora(new Date());
		evento.setFoto("");
		evento.setGenero("Jazz");
		evento.setPolitica_acceso("Solo personal autorizado");
		evento.setPrecio(25.50);
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
		evento.setPrecio(25.50);
		MRecinto mrecinto = new MRecinto();
		mrecinto.setId_recinto(3);
		mrecinto.setNombre("Aula Magna");
		mrecinto.setLugar("Madrid");
		mrecinto.setDireccion("Calle del Carmen");
		mrecinto.setAforo(90);
		evento.setMrecinto(mrecinto);

		String editar = ievento.editarEvento(evento);
		// assertTrue("ok".equalsIgnoreCase(editar));
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
