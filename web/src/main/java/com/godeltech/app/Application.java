package com.godeltech.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Dmitry Chueshov 25.01.2021 02:13
 *
 */
@SpringBootApplication
@EnableJpaRepositories

public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
