package es.ramirez.venta;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.fasterxml.jackson.core.JsonProcessingException;

import es.ramirez.venta.interfaces.IEntrada;
import es.ramirez.venta.model.MEntrada;

/**
 * MicroVentaApplicationTests.java clase para las pruebas unitarias
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 11/08/2021
 */

@SpringBootTest
class MicroVentaApplicationTests {

	@Autowired
	IEntrada ientrada;

	@Test
	void contextLoads() {
	}

	@Test
	public void crearEntrada() throws ParseException {

		MEntrada entrada = new MEntrada();

		entrada.setIdEntrada(4);
		entrada.setIdEvento(1);
		entrada.setIdUsuario(1);
		entrada.setNombreEntrada("VIP");
		entrada.setTipoEntrada("Entrada de pago");
		entrada.setEntradasPorPedido(1);
		entrada.setEstadoReserva("SIN RESERVAR");
		entrada.setIva(5.0);
		entrada.setPrecio(15.0);
		entrada.setIvaAPagar(0.0);
		entrada.setSubtotal(0.0);
		entrada.setSaldoFinal(0.0);
		entrada.setTipoPago("Tarjeta de crédito");
		entrada.setTarifa("Añadir al precio");
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		Date fechaI = objSDF.parse("20-08-2021 09:00");
		entrada.setFechaInicioVenta(fechaI);
		Date fechaF = objSDF.parse("24-08-2021 16:00");
		entrada.setFechaFinVenta(fechaF);

		String crear = ientrada.crearEntrada(entrada);

		assertEquals("ok", crear);
	}

	@Test
	public void editarEntrada() throws ParseException {
		MEntrada entrada = new MEntrada();

		entrada.setIdEntrada(4);
		entrada.setIdEvento(1);
		entrada.setIdUsuario(1);
		entrada.setNombreEntrada("VIP");
		entrada.setTipoEntrada("Entrada de pago");
		entrada.setEntradasPorPedido(1);
		entrada.setEstadoReserva("SIN RESERVAR");
		entrada.setIva(6.0);
		entrada.setPrecio(16.0);
		entrada.setIvaAPagar(0.0);
		entrada.setSubtotal(0.0);
		entrada.setSaldoFinal(0.0);
		entrada.setTipoPago("Tarjeta de crédito");
		entrada.setTarifa("Añadir al precio");
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		Date fechaI = objSDF.parse("20-08-2021 09:00");
		entrada.setFechaInicioVenta(fechaI);
		Date fechaF = objSDF.parse("24-08-2021 16:00");
		entrada.setFechaFinVenta(fechaF);

		String editar = ientrada.editarEntrada(entrada);
		assertNotEquals("error", editar);
	}

	@Test
	public void eliminarEntrada() {

		String eliminar = ientrada.deleteById(2);

		assertFalse("error".equalsIgnoreCase(eliminar));
	}

	@Test
	public void findAll() {
		assertTrue(!ientrada.findAll().isEmpty());
	}

	@Test
	public void findById() {
		assertNotNull(ientrada.findById(1));
	}

	@Test
	public void findByNombre() {
		assertFalse(ientrada.findByNombre("VIP").isEmpty());
	}

	@Test
	public void findByTipo() {
		assertTrue(!ientrada.findByTipo("Entrada").isEmpty());
	}

	@Test
	public void pagoTicket() throws JsonProcessingException {
		boolean reservada = ientrada.pagoTickest(4);
		assertTrue(reservada);
	}

}
