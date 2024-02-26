package com.spring.udemy.mvc.mvccrud.controller;

import com.spring.udemy.mvc.mvccrud.entity.Employee;
import com.spring.udemy.mvc.mvccrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // Save employee
        employeeService.save(employee);

        // Use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }


}
