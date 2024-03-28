package com.spring.udemy.aop.aopdemo.dao;

import com.spring.udemy.aop.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);
    boolean doSomething();
}
