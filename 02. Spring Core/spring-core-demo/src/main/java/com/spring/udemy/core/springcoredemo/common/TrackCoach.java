package com.spring.udemy.core.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // It´s only called when needed
public class TrackCoach implements Coach {

    // Constructor made for testing Lazy Initialization
    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K!";
    }
}
