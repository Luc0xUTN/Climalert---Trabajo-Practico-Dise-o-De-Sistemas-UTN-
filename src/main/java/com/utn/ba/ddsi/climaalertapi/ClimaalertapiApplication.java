package com.utn.ba.ddsi.climaalertapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClimaalertapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimaalertapiApplication.class, args);
	}

}
