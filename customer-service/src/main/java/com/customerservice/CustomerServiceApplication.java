package com.customerservice;

import com.customerservice.config.CustomerConfigParams;
import com.customerservice.entities.Customer;
import com.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class) //pour que 2eme manière de configuration marchera
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder().name("mohamed").email("m@gmail.com").build());
            customerRepository.save(Customer.builder().name("imane").email("i@gmail.com").build());
            customerRepository.save(Customer.builder().name("yassine").email("y@gmail.com").build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("=================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
            });
        };
    }

}
