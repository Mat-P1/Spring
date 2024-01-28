package com.spring.udemy.core.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    // Constructor made for testing Lazy Initialization
    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!";
    }
}
