package com.dasare.estoque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customPoenAPI() {
		return new OpenAPI().info(new Info().title("Controle de Estoque Dinamica").version("v1")
				.description(" Coletar entrada de produtos e enviar produtos para obras")
				.termsOfService("https://dasare.com.br")
				.license(new License().name("Apache 3.0").url("https://dasare.com.br")));
	}

}
