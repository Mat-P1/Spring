package com.spring.udemy.core.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // Marks class as a Spring Bean for Dependency Injection
@Primary   // Marks this class as default for Dependency Injection. Lower priority than Qualifier.
public class CricketCoach implements Coach {

    // Constructor made for testing Lazy Initialization
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}
