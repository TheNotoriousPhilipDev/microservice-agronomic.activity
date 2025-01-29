package org.agomez.backend.msvc.agronomic.activities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcAgronomicActivitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcAgronomicActivitiesApplication.class, args);
	}

}
