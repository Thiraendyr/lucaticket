package com.lucaticket.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucaticket.clientes.model.dto.Cliente_DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banco")
@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * 
 * Cliente
 * 
 * @author David
 * @version 1.0
 * @see 19/08/2021
 * @see Clase modelo que interacciona directamente con la base de datos
 * 
 */
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String contrasenia;
	@Column
	private Double saldo;
	@Column(name = "numero_cuenta")
	private String numeroCuenta;

	public Cliente(Cliente_DTO cliente_dto) {
		this.idCliente = cliente_dto.getIdCliente();
		this.nombre = cliente_dto.getNombre();
		this.apellido = cliente_dto.getApellido();
		this.contrasenia = cliente_dto.getContrasenia();
		this.saldo = cliente_dto.getSaldo();
		this.numeroCuenta = cliente_dto.getNumeroCuenta();
	}
	
}
