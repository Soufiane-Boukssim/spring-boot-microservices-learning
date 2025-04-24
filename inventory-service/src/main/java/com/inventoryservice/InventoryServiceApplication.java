package com.inventoryservice;

import com.inventoryservice.entities.Product;
import com.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("computer").price(3200).quantity(11).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("printer").price(1200).quantity(2).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("smart phone").price(2200).quantity(8).build());
			productRepository.findAll().forEach(p -> {
				System.out.println("=================");
				System.out.println(p.toString());
			});
		};
	}

}
