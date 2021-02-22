package com.github.lbovolini.vaccineapi.configuration;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new SnakeCasePhysicalNamingStrategy();
    }
}
