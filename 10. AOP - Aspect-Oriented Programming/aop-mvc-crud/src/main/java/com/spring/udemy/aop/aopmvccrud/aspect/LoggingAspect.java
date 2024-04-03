package com.spring.udemy.aop.aopmvccrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    // Setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // Setup pointcut declaration
    @Pointcut("execution(* com.spring.udemy.aop.aopmvccrud.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.spring.udemy.aop.aopmvccrud.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.spring.udemy.aop.aopmvccrud.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {}

    // Add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // Display method called
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @Before: calling method: " + method);

        // Get and display arguments
        Object[] args = joinPoint.getArgs();

        for (Object a : args) {
            logger.info("=====> Arguments: " + a);
        }
    }

    // Add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        // Display method called
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @AfterReturning: calling method: " + method);

        // Display data returned
        logger.info("=====> Result: " + result);
    }
}
