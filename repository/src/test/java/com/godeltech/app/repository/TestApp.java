package com.godeltech.app.repository;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Dmitry Chueshov 08.01.2021 02:13
 *
 */

@SpringBootApplication
@EntityScan(basePackages = "com/godeltech/app/entity")
@PropertySource("classpath:app.properties")
public class TestApp {
    
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }
  
}