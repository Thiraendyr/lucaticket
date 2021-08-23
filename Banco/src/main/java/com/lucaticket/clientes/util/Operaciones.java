package com.lucaticket.clientes.util;

import java.util.Random;

import com.lucaticket.clientes.model.dto.Cliente_DTO;

/**
 * 
 * Operaciones
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Clase util que contiene operaciones
 *
 */
public class Operaciones {

	/**
	 * Método que genera un numero aleatorio
	 * 
	 * @param longitud del numero
	 * @return cadena con el numero
	 */
	public static String numeroAleatorio(int longitud) {
		String numeroStr = "";
		Random ran = new Random();
		
		for (int i = 0; i < longitud; i++) {
			numeroStr = numeroStr.concat(String.valueOf(ran.nextInt(10)));
		}
		
		return numeroStr;
	}
	
	/**
	 * Método que mezcla datos de un cliente en caso de haber campos vacíos
	 * 
	 * @param cliente que puede contener campos vacíos, cliente de la base de datos
	 * @return cliente completo
	 */
	public static Cliente_DTO parseoCliente(Cliente_DTO clienteEntrada, Cliente_DTO clienteBD) {
		Cliente_DTO cliente = clienteEntrada;
		if(clienteEntrada.getNombre() == null) 
			cliente.setNombre(clienteBD.getNombre());
		if(clienteEntrada.getApellido() == null) 
			cliente.setApellido(clienteBD.getApellido());
		if(clienteEntrada.getContrasenia() == null) 
			cliente.setContrasenia(clienteBD.getContrasenia());
		if(clienteEntrada.getSaldo() == null) 
			cliente.setSaldo(clienteBD.getSaldo());
		if(clienteEntrada.getNumeroCuenta() == null) 
			cliente.setNumeroCuenta(clienteBD.getNumeroCuenta());
		return cliente;
	}
}
