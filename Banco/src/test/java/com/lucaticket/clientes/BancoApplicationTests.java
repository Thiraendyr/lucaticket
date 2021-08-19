package com.lucaticket.clientes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucaticket.clientes.util.Operaciones;

@SpringBootTest
class BancoApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Operaciones.numeroAleatorio(22));
	}

}
