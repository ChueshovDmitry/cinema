package com.godeltech.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dmitry Chueshov 25.01.2021 02:13
 *
 */
@SpringBootApplication(scanBasePackages = "com.godeltech.app.*")

public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
