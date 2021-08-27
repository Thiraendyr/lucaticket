package es.bligor.mc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.bligor.mc.entity.Venta;
import es.bligor.mc.service.VentaService;

@RestController
public class VentaController{

	@Autowired
	private VentaService ventaService;

	@PostMapping("/entrada")
	public ResponseEntity<Venta> add(@RequestBody Venta venta) {
		Venta v = ventaService.add(venta);
		return new ResponseEntity<Venta>(v, HttpStatus.OK);
	}

	@PutMapping("/entrada")
	public ResponseEntity<String> update(@RequestBody Venta venta) {
		ventaService.update(venta);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping("/entrada/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		ventaService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/entrada")
	public ResponseEntity<List<Venta>> getAll() {
		return new ResponseEntity<List<Venta>>(ventaService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/entrada/{id}")
	public ResponseEntity<Venta> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Venta>(ventaService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/entrada/filtroNombre/{nombre}")
	public ResponseEntity<List<Venta>> getByNombre(@PathVariable("nombre") String nombre) {
		return new ResponseEntity<List<Venta>>(ventaService.getByNombre(nombre), HttpStatus.OK);
	}
	
	@GetMapping("/reserva/{idEntrada}")
	public ResponseEntity<Boolean> getReserva(@PathVariable("idEntrada") int idEntrada) {
		return new ResponseEntity<Boolean>(ventaService.getPagoTicket(idEntrada), HttpStatus.OK);
	}

}
