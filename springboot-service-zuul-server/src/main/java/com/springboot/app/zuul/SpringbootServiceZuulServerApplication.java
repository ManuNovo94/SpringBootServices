package com.springboot.app.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableEurekaClient
@EnableZuulProxy    //habilitar zuul y cliente de eureka, despues añadir application properties configuraciones de uso 
@SpringBootApplication
public class SpringbootServiceZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceZuulServerApplication.class, args);
		
		
	}

}
