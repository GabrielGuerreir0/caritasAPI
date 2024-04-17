package br.com.caritas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI().info(new Info()
	            .title("CARITAS RESTful API with Java 18 and Spring Boot 3")
	            .version("v1")
	            .description("API para gerenciamento da aplicação web da fundação Caritas")
	            .termsOfService("https://pub.caritas.com.br/resp-api") // Corrigido o URL
	            .license(new License()
	                .name("Apache 2.0")
	                .url("https://pub.caritas.com.br/resp-api") // Corrigido o URL
	            )
	    );
	}
}
