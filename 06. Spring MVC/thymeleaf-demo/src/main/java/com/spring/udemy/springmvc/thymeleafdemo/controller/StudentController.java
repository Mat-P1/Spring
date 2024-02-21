package com.spring.udemy.springmvc.thymeleafdemo.controller;

import com.spring.udemy.springmvc.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // Create new student object
        Student student = new Student();

        // Add student object to the model
        model.addAttribute("student", student);

        // Add list of countries to the model
        model.addAttribute("countries", countries);

        // Add list of languages to the model
        model.addAttribute("languages", languages);

        // Add list of systems to the model
        model.addAttribute("systems", systems);

        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {

        // Log input data
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

        return "studentConfirmation";
    }
}
