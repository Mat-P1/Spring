package com.spring.udemy.aop.aopdemo;

import com.spring.udemy.aop.aopdemo.dao.AccountDAO;
import com.spring.udemy.aop.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {

            // beforeAdviceDemo(accountDAO, membershipDAO);
            // afterReturningAdviceDemo(accountDAO);
            // afterThrowingAdviceDemo(accountDAO);
            afterAdviceDemo(accountDAO);
        };
    }

    private void beforeAdviceDemo(AccountDAO accountDAO, MembershipDAO membershipDAO) {

        Account account = new Account();
        account.setName("Test");
        account.setLevel("Platinum");
        accountDAO.addAccount(account, true);
        accountDAO.doSomething();

        // Call accountDAO getter/setter
        accountDAO.setName("testSetter");
        accountDAO.setServiceCode("123456");

        accountDAO.getName();
        accountDAO.getServiceCode();

        // Call business method
        membershipDAO.addMembership();
        membershipDAO.deleteMembership();
    }

    private void afterReturningAdviceDemo(AccountDAO accountDAO) {

        // Call method to find accounts
        List<Account> accounts = accountDAO.findAccounts();

        // Display accounts
        System.out.println("\n\n Main Program: afterReturningAdviceDemo" + "\n----" + accounts + "\n");
    }

    private void afterThrowingAdviceDemo(AccountDAO accountDAO) {

        // Call method to find accounts
        List<Account> accounts = null;

        try {
            // Add boolean flag to simulate exceptions
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);

        } catch (Exception exception) {
            System.out.println("\n\n Main Program: Exception" + exception);
        }

        // Display accounts
        System.out.println("\n\n Main Program: afterThrowingAdviceDemo" + "\n----" + accounts + "\n");
    }

    private void afterAdviceDemo(AccountDAO accountDAO) {

        // Call method to find accounts
        List<Account> accounts = null;

        try {
            // Add boolean flag to simulate exceptions
            boolean tripWire = false; // change to false or true;
            accounts = accountDAO.findAccounts(tripWire);

        } catch (Exception exception) {
            System.out.println("\n\n Main Program: Exception" + exception);
        }

        // Display accounts
        System.out.println("\n\n Main Program: afterThrowingAdviceDemo" + "\n----" + accounts + "\n");
    }
}
