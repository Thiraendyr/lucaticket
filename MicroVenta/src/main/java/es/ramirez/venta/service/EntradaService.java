package es.ramirez.venta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ramirez.venta.banco.BancoService;
import es.ramirez.venta.banco.Cliente;
import es.ramirez.venta.interfaces.IEntrada;
import es.ramirez.venta.model.MEntrada;
import es.ramirez.venta.model.entity.Entrada;
import es.ramirez.venta.repository.EntradaRepository;
import es.ramirez.venta.util.Convertidor;

/**
 * EntradaService.java clase que implementa las operaciones interfaz IEntrada.java
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Service
public class EntradaService implements IEntrada {

	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	EntradaRepository entradaRepository;

	@Autowired
	BancoService bancoService;

	@Override
	public MEntrada findById(Integer id) {
		Entrada entrada = entradaRepository.findById(id).orElse(null);
		if (entrada == null) {
			log.error("La entrada no existe");
			return null;
		} else {
			log.info("Se ha encontrado la entrada");
			return Convertidor.entradaEntityToModel(entrada);
		}
	}

	@Override
	public String crearEntrada(MEntrada me) {
		Entrada entrada = entradaRepository.findById(me.getIdEntrada()).orElse(null);
		if (entrada != null) {
			log.error("La entrada ya existe");
			return "error";
		} else {
			entrada = new Entrada();
			entrada = Convertidor.mentradaToEntity(me);
			entrada = entradaRepository.save(entrada);
			log.info("El evento se ha creado correctamente");
			return "ok";
		}
	}

	@Override
	public String editarEntrada(MEntrada me) {
		Entrada entrada = entradaRepository.findById(me.getIdEntrada()).orElse(null);
		if (entrada == null) {
			log.error("La entrada no existe");
			return "error";
		} else {
			entrada.setIdEntrada(me.getIdEntrada());
			entrada.setIdEvento(me.getIdEvento());
			entrada.setIdUsuario(me.getIdUsuario());
			entrada.setNombreEntrada(me.getNombreEntrada());
			entrada.setTipoEntrada(me.getTipoEntrada());
			entrada.setEntradasPorPedido(me.getEntradasPorPedido());
			entrada.setEstadoReserva(me.getEstadoReserva());
			entrada.setIva(me.getIva());
			entrada.setPrecio(me.getPrecio());
			entrada.setIvaAPagar((me.getPrecio() * me.getEntradasPorPedido()) * me.getIva() / 100);
			entrada.setSubtotal(me.getPrecio() * me.getEntradasPorPedido());
			entrada.setSaldoFinal((me.getPrecio() * me.getEntradasPorPedido())
					+ ((me.getPrecio() * me.getEntradasPorPedido()) * me.getIva() / 100));
			entrada.setTarifa(me.getTarifa());
			entrada.setTipoPago(me.getTipoPago());
			entrada.setFechaInicioVenta(me.getFechaInicioVenta());
			entrada.setFechaFinVenta(me.getFechaFinVenta());
			entrada = entradaRepository.save(entrada);
			log.info("La entrada se ha modificado correctamente");
			return "ok";
		}
	}

	@Override
	public String deleteById(Integer id) {
		Entrada e = entradaRepository.findById(id).orElse(null);
		if (e == null) {
			log.error("La entrada no existe");
			return "error";
		} else {
			entradaRepository.delete(e);
			log.info("La entrada se ha eliminado correctamente");
			return "ok";
		}
	}

	@Override
	public List<MEntrada> findAll() {
		log.info("Las entradas se han listado correctamente");
		return Convertidor.listEntradaEntityToModel(entradaRepository.findAll());
	}

	@Override
	public List<MEntrada> findByNombre(String nombre) {
		List<MEntrada> lista = Convertidor.listEntradaEntityToModel(entradaRepository.findAll());
		lista = lista.stream().filter(t -> t.getNombreEntrada().matches(".*" + nombre + ".*"))
				.collect(Collectors.toList());
		return lista;
	}

	@Override
	public List<MEntrada> findByTipo(String tipoEntrada) {
		List<MEntrada> lista = Convertidor.listEntradaEntityToModel(entradaRepository.findAll());
		lista = lista.stream().filter(t -> t.getTipoEntrada().matches(".*" + tipoEntrada + ".*"))
				.collect(Collectors.toList());
		return lista;
	}

	@Override
	public boolean pagoTickest(Integer idEntrada) throws JsonProcessingException {
		Entrada entrada = entradaRepository.findById(idEntrada).orElse(null);
		boolean reservada = false;
		if (entrada != null) {
			Cliente cliente = bancoService.getClienteById(entrada.getIdUsuario());
			if (cliente != null) {
				if (cliente.getSaldo() >= entrada.getSaldoFinal()) {
					ObjectMapper objectMapper = new ObjectMapper();
					String clienteJson = objectMapper.writeValueAsString(cliente);
					int status = bancoService.getJsonCliente(clienteJson);
					if (status == 200) {
						entrada.setEstadoReserva("RESERVADA");
						entradaRepository.save(entrada);
						reservada = true;
						log.info("Se reservado correctamente la entrada");
					} else {
						log.error("No se ha podido realizar el pago");
					}

				} else {
					log.error("No se ha podido realizar el pago, saldo insuficiente");
				}

			} else {
				log.error("No eres cliente del banco");
			}

		} else {
			log.error("No existe la entrada");
		}

		return reservada;
	}

}
