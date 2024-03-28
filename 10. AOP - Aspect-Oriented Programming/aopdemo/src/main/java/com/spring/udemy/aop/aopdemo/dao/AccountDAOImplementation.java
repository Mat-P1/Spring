package com.spring.udemy.aop.aopdemo.dao;

import com.spring.udemy.aop.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImplementation implements AccountDAO {

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
