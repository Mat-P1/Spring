package com.spring.udemy.aop.aopdemo.aspects;

import com.spring.udemy.aop.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    @Before("com.spring.udemy.aop.aopdemo.aspects.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");

        // Display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display method arguments

        // Get args
        Object[] args = joinPoint.getArgs();

        // Loop through args
        for (Object o : args) {
            System.out.println(o);

            if (o instanceof Account) {
                // Downcast and print account specific things
                Account account = (Account) o;
                System.out.println("Account name: " + ((Account) o).getName());
                System.out.println("Account name: " + ((Account) o).getLevel());
            }
        }
    }
}
