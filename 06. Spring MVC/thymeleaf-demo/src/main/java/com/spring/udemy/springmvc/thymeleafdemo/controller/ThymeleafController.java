package com.spring.udemy.springmvc.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    // Create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("newDate", new java.util.Date());

        return "helloworld";
    }
}
