package com.spring.udemy.aop.aopdemo.dao;

import com.spring.udemy.aop.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AccountDAOImplementation implements AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {

        /*
        // Create sample accounts
        Account ac1 = new Account("John", "Silver");
        Account ac2 = new Account("Madhu", "Platinum");
        Account ac3 = new Account("Luca", "Gold");

        // Add accounts to list
        return new ArrayList<>(Arrays.asList(ac1, ac2, ac3));
        */

        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // For learning purposes. Simulate an exception
        if (tripWire) {
            throw new RuntimeException("ERROR");
        }

        // Create sample accounts
        Account ac1 = new Account("John", "Silver");
        Account ac2 = new Account("Madhu", "Platinum");
        Account ac3 = new Account("Luca", "Gold");

        // Add accounts to list
        return new ArrayList<>(Arrays.asList(ac1, ac2, ac3));
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Adding account");
    }

    @Override
    public boolean doSomething() {
        System.out.println(getClass() + "Doing something....");
        return false;
    }
}
