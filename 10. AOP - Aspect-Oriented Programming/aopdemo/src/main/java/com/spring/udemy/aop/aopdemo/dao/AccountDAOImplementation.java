package com.spring.udemy.aop.aopdemo.dao;

import com.spring.udemy.aop.aopdemo.Account;
import org.springframework.stereotype.Repository;

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
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Adding account");
    }

    @Override
    public boolean doSomething() {
        System.out.println(getClass() + "Doing something....");
        return false;
    }
}
