package com.spring.udemy.aop.aopdemo;

import com.spring.udemy.aop.aopdemo.dao.AccountDAO;
import com.spring.udemy.aop.aopdemo.dao.MembershipDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {

            beforeAdviceDemo(accountDAO, membershipDAO);
        };
    }

    private void beforeAdviceDemo(AccountDAO accountDAO, MembershipDAO membershipDAO) {

        Account account = new Account();

        // Call business method
        accountDAO.addAccount(account, true);
        accountDAO.doSomething();
        membershipDAO.addMembership();
        membershipDAO.deleteMembership();

    }
}
