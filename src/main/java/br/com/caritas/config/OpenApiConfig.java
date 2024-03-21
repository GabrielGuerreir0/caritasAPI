package br.com.caritas.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
   public  OpenAPI custonOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("CARITAS RESTful API with Java 18 and spring boot 3")
						.version("v1")
						.description("API para gerenciamento da aplicação web da fundação caritas")
						.termsOfService("https//:pub.caritas.com.br/resp-api")
						.license(new License().name("Apache 2.0")
								.url("https//:pub.caritas.com.br/resp-api")
								)
					);
	}
}
