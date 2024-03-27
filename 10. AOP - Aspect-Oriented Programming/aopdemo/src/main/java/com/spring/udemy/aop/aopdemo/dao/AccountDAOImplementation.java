package com.spring.udemy.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImplementation implements AccountDAO {

    @Override
    public void addAccount() {

        System.out.println(getClass() + ": Adding account");
    }
}
