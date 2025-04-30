package com.customerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

//1ere manière de configuration
@RestController
public class ConfigTestRestController {
    @Value("${customer.params.x}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;

    @GetMapping("/testConfig1")
    public Map<String, String> configTest() {
        return Map.of("p1", p1, "p2", p2);
    }

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @GetMapping("/testConfig2")
    public CustomerConfigParams configTest2() {
        return customerConfigParams;
    }

}
