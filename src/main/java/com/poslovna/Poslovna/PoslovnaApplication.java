package com.poslovna.Poslovna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@Configuration
public class PoslovnaApplication {

	 @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper;
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(PoslovnaApplication.class, args);
	}

}
