package com.spring.udemy.aop.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

    // @Before("execution(public void addAccount())")
    // @Before("execution(public void com.spring.udemy.aop.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* add*(com.spring.udemy.aop.aopdemo.Account))")
    // @Before("execution(* add*(com.spring.udemy.aop.aopdemo.Account, ..))")
    // @Before("execution(* com.spring.udemy.aop.aopdemo..add*(..))")
    // @Before("execution(* com.spring.udemy.aop.aopdemo.dao.*.*(..))")

    @Pointcut("execution(* com.spring.udemy.aop.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // Create a pointcut for getter method
    @Pointcut("execution(* com.spring.udemy.aop.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // Create a pointcut for setter method
    @Pointcut("execution(* com.spring.udemy.aop.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // Create a pointcut: include package and excludes getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
