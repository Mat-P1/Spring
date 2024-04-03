package com.spring.udemy.aop.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficServiceImplementation implements TrafficService {

    @Override
    public String getTrafficService() {

        // Simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Return string
        return "Heavy traffic";
    }

    @Override
    public String getTrafficService(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed!");
        }
        return getTrafficService();
    }
}
