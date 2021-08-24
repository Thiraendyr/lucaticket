package es.ramirez.venta.banco;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Cliente.java clase para representar un Cliente_DTO.java
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Cliente_DTO")
public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private Double saldo;
	private String numeroCuenta;
}
