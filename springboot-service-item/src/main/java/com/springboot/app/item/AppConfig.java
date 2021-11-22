package com.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean("ClienteRest")
	public RestTemplate registrarResTemplate() 
	{
		return new RestTemplate();
	}
	
	
}