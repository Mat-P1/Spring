package com.spring.udemy.aop.aopdemo.aspects;

import com.spring.udemy.aop.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    // Add new advice for @AfterReturning on the findAccounts() method
    @AfterReturning(
            pointcut = "execution(* com.spring.udemy.aop.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // Print out which method @AfterReturning is being applied on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);

        // Print out method's results
        System.out.println("\n=====> Result is: " + result);

        // Post-processing data. Convert account's names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====> Result is: " + result);
    }

    // Add new advice for @AfterThrowing on the findAccounts() method
    @AfterThrowing(
            pointcut = "execution(* com.spring.udemy.aop.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        // Print out which method @AfterThrowing is being applied on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterThrowing on method: " + method);

        // Log exception
        System.out.println("\n=====> Exception is: " + exception);
    }

    // Add new advice for @After on the findAccounts() method
    @After("execution(* com.spring.udemy.aop.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // Print out which method @AfterThrowing is being applied on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @After (finally) on method: " + method);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // Loop through accounts
        for (Account a : result) {

            // Get uppercase version
            String upperCaseName = a.getName().toUpperCase();

            // Update names
            a.setName(upperCaseName);
        }
    }

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
                System.out.println("Account name: " + ((Account) o).getName());
                System.out.println("Account name: " + ((Account) o).getLevel());
            }
        }
    }
}
