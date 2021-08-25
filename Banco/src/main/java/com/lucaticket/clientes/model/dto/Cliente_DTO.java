package com.lucaticket.clientes.model.dto;

import com.lucaticket.clientes.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * 
 * Cliente_DTO
 * 
 * @author David
 * @version 1.0 
 * @see 19/08/2021 
 * @see Clase usada para no interactuar con la base de datos
 *
 */
public class Cliente_DTO {
	private Integer idCliente;

	private String nombre;
	private String apellido;
	private String contrasenia;
	private Double saldo;
	private String numeroCuenta;
	
	public Cliente_DTO(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nombre = cliente.getNombre();
		this.apellido = cliente.getApellido();
		this.contrasenia = cliente.getContrasenia();
		this.saldo = cliente.getSaldo();
		this.numeroCuenta = cliente.getNumeroCuenta();
	}
}
