package com.dev.user.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
@EntityScan("com.dev.user.entity")
@EnableJpaRepositories(basePackages = {"com.dev.user.repository"})
public class Configuration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
