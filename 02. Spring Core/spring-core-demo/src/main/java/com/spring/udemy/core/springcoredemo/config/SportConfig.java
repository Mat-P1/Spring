package com.spring.udemy.core.springcoredemo.config;

import com.spring.udemy.core.springcoredemo.common.Coach;
import com.spring.udemy.core.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // Bean Ids can be customized
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
