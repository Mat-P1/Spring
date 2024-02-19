package com.spring.udemy.springmvc.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // New controller method to show initial HTML form

    @RequestMapping("/showForm")
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
}
