package com.aston.ecommerce.asmar;

import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.service.IFlickrService;
import com.aston.ecommerce.asmar.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class AsmarApplication implements CommandLineRunner {

    static Logger logger = Logger.getLogger(AsmarApplication.class);

    @Autowired
    private IFlickrService flickrService;
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(AsmarApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        //Product product = productRepository.findById(1l).get();
        System.out.println("product : ");
        //System.out.println(product);
    }
}