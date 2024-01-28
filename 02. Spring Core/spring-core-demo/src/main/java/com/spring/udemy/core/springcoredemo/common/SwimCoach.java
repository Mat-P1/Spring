package com.spring.udemy.core.springcoredemo.common;

public class SwimCoach implements Coach {

    // Constructor made for testing Lazy Initialization
    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up";
    }
}
