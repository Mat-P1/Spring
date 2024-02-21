package com.spring.udemy.springmvc.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // New controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworldForm";
    }

    // Method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // Controller method to read form data and add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model) {

        // Read request parameter from HTML form

        String name = request.getParameter("studentName");

        // Convert data to upper case

        name = name.toUpperCase();

        // Create message

        String result = "Yo!" + name;

        // add message to the model

        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        // Convert data to upper case

        name = name.toUpperCase();

        // Create message

        String result = "Hey my friend! " + name;

        // add message to the model

        model.addAttribute("message", result);

        return "helloworld";
    }
}
