package com.aston.ecommerce.asmar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.aston.ecommerce.asmar.dao")
@EntityScan(basePackages="com.aston.ecommerce.asmar.entity")
public class AsmarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsmarApplication.class, args);
    }

}
