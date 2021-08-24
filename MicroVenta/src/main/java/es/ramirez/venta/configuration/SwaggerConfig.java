package es.ramirez.venta.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig.java clase para diseñar, construir, documentar y consumir el
 * servicio evento(RestFull)
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Método que accede a la clase controladora Controlador.java para consumir y documentar las
	 * operaciones del servicio evento
	 * 
	 * @return Docket resultado para la configuración
	 */
	@Bean
	public Docket apiDocker() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("es.ramirez.venta.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Ventas API",
                "Spring Boot Swagger Ventas API for Lucaticket",
                "1.0",
                "Terms of Service",
                new Contact("Leyanis Ramírez", "",
                        "leduanisramirez@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

		return apiInfo;
	}
}
