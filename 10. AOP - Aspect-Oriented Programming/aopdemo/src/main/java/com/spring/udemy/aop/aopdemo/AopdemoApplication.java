package com.spring.udemy.aop.aopdemo;

import com.spring.udemy.aop.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
        return runner -> {

            beforeAdviceDemo(accountDAO);
        };
    }

    private void beforeAdviceDemo(AccountDAO accountDAO) {

        // Call business method
        accountDAO.addAccount();
    }

}
