package com.spring.udemy.mvc.mvccrud.controller;

import com.spring.udemy.mvc.mvccrud.entity.Employee;
import com.spring.udemy.mvc.mvccrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Mappings

    @GetMapping("/list")
    public String listEmployees(Model model) {

        // GET employees from database
        List<Employee> employeesList = employeeService.findAll();

        // Add to spring model
        model.addAttribute("employees", employeesList);

        return "list-employees";
    }
}
