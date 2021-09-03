package es.bligor.mc.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import es.bligor.mc.entity.Evento;
import es.bligor.mc.entity.Usuario;
import es.bligor.mc.service.EmailService;
import es.bligor.mc.service.EventoService;
import es.bligor.mc.service.UsuarioService;

@Service
public class Consumer {

	@Autowired
	public EventoService evService;
	
	@Autowired
	public UsuarioService uService;
	
	@Autowired
	public EmailService eService;
	
	@KafkaListener(topics="eventos", groupId="group_id")
	public void consumir(String msg) throws IOException {
		
		System.out.println("------Evento recibido--------");
		System.out.println("ID DEL EVENTO: " + msg);
		
		Evento evento = evService.getById(Integer.parseInt(msg));
		
		
		
		for(Usuario u : uService.getUsuarios()) {
			String msgBody = "Hola " + u.getNombre() + "\nSe ha creado un nuevo evento."
							 + "\nID del evento: " + evento.getId_evento()
							 + "\nNombre: " + evento.getNombre() + "\nDescripción: " + evento.getDesc_ext()
							 + "€\nDirección: "  + evento.getMrecinto().getDireccion()   + "\n Un saludo";
			
			eService.sendSimpleMessage(u.getEmail(), "Alerta de un nuevo Evento", msgBody);
		}
		
	}
}
