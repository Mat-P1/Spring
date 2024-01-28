package com.spring.udemy.core.springcoredemo.rest;

import com.spring.udemy.core.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency.
    @Autowired // Field injection. Not recommended.
    private Coach myCoach;
    private final Coach anotherCoach;

    // Define a CONSTRUCTOR for dependency injection.
    // Qualifier annotation has a higher priority than Primary annotation.
    @Autowired // Tells Spring to inject a dependency. Optional if you only have one constructor.
    public DemoController(
            @Qualifier("aquatic") Coach theCoach,
            @Qualifier("aquatic") Coach theAnotherCoach
            ) {
        System.out.println("In constructor: " + getClass().getName()); // Made for testing Lazy Initialization.
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    // Define a SETTER for dependency injection.
    @Autowired // Method name is customizable.
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    // Define GetMapping for "dailyworkout" endpoint.
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout(); 
    }

    // Bean Scope check.
    // Scope Annotation in Baseball class for PROTOTYPE scope.
    @GetMapping("/checkscope")
    public String checkScope() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
