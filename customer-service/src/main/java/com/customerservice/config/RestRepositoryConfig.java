package com.customerservice.config;

import com.customerservice.entities.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//pour integrer id dans les reponces des api
//Situation                                       Faut-il ajouter RestRepositoryConfig
// Utilisation de Spring Data REST (automatique)  Oui
// Création manuelle de services + contrôleurs    Non
@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Customer.class);
    }
}