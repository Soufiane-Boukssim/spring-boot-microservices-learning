package com.billingservice;

import com.billingservice.entities.Bill;
import com.billingservice.entities.ProductItem;
import com.billingservice.feign.CustomerRestClient;
import com.billingservice.feign.ProductRestClient;
import com.billingservice.models.Customer;
import com.billingservice.models.Product;
import com.billingservice.repositories.BillRepository;
import com.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication @EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient) {
		return args -> {

			Collection<Customer> customers= customerRestClient.getAllCustomers().getContent();
			Collection<Product> products= productRestClient.getAllProducts().getContent();

			customers.forEach(customer -> {

				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);

				products.forEach(product -> {
					ProductItem productItem= ProductItem.builder()
							.bill(bill)
							.productId(product.getId())
							.quantity(1+new Random().nextInt(10))
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});

			});

		};
	}

}
