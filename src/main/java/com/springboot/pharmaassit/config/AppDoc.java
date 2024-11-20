package com.springboot.pharmaassit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppDoc {

	Info info(){
		return new Info().title(" Pharma Assist") 
				.description("Pharmacy Management System" + 
						"Built using Spring Boot ,The Api covers basic methods"+
						"covering all the CRUD operations on the multiple entities")
				.version("v1").contact(contact());
	}

	Contact contact() {
		// TODO Auto-generated method stub
		return new Contact().email("varada883@gmail.com")
				.name("Varadaraju N Y");

	}

	@Bean
	OpenAPI openAPI() {
		return new  OpenAPI().info(info());
	}
}

