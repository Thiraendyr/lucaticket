package es.bligor.mc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroConsumerApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	RestTemplate get_RestTemplate() {
		return new RestTemplate();
	}


}
