package com.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//2eme manière de configuration
@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigParams(int x, int y) {

}
