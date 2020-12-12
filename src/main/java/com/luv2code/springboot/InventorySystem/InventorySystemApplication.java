package com.luv2code.springboot.InventorySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.luv2code.springboot.InventorySystem.dao")
public class InventorySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySystemApplication.class, args);
	}

}
