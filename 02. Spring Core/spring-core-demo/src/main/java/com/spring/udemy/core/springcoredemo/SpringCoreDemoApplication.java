package com.spring.udemy.core.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.spring.udemy.core.springcoredemo",
                            "com.spring.udemy.core.util"}
) // Explicitly list base packages to scan
public class SpringCoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreDemoApplication.class, args);
    }

}
