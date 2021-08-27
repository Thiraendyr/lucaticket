package es.bligor.mc.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	private static String topic = "eventos";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMensaje(String msg) {
		this.kafkaTemplate.send(topic, msg);
	}
	
}
