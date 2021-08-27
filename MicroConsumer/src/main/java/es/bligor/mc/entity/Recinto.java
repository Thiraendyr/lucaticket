package es.bligor.mc.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("MRecinto")
public class Recinto {
	private Integer id_recinto;
	private String nombre;
	private String lugar;
	private String direccion;
	private Integer aforo;
}
