package com.spring.udemy.aop.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    // @Before("execution(public void addAccount())")
    // @Before("execution(public void com.spring.udemy.aop.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* add*(com.spring.udemy.aop.aopdemo.Account))")
    // @Before("execution(* add*(com.spring.udemy.aop.aopdemo.Account, ..))")
    // @Before("execution(* com.spring.udemy.aop.aopdemo..add*(..))")
    @Before("execution(* com.spring.udemy.aop.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }
}
