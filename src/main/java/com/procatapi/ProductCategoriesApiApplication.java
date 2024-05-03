package com.procatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.procatapi")
public class ProductCategoriesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoriesApiApplication.class, args);
	}

}
