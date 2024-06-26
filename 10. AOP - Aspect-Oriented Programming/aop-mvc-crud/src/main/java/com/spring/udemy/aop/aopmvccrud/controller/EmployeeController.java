package com.spring.udemy.aop.aopmvccrud.controller;

import com.spring.udemy.aop.aopmvccrud.service.EmployeeService;
import com.spring.udemy.aop.aopmvccrud.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

        // Get employee from service layer
        Employee employee = employeeService.findById(id);

        // Set employee in model to pre-populate form
        model.addAttribute("employee", employee);

        // Send over to form


        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // Save employee
        employeeService.save(employee);

        // Use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id, Model model) {

        // Delete employee
        employeeService.deleteById(id);

        // Redirect to employees/list
        return "redirect:/employees/list";
    }
}
