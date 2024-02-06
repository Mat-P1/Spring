package com.spring.udemy.restapi.employeecrud.rest;

import com.spring.udemy.restapi.employeecrud.entity.Employee;
import com.spring.udemy.restapi.employeecrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // Define field for EmployeeService

    private final EmployeeService employeeService;

    // Inject EmployeeService

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET "/employees" endpoint

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // GET "/employees/{employeeId}" endpoint

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

    // POST "/employees" endpoint

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // Just in case someone pass an id in JSON. Application creates a new employee instead of updating

        employee.setId(0);

        return employeeService.save(employee);
    }

    // PUT "/employees" endpoint

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    // DELETE "/employees/{employeeId}" endpoint

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        // Thrown exception if null

        if (employee == null) {
            throw new RuntimeException("Employee id not found or employee already deleted - ID: - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee " +
                "Id: " + employee.getId() +
                " First Name: " + employee.getFirstName() +
                " Second Name: " + employee.getLastName() +
                " E-mail: " + employee.getEmail();
    }
}
