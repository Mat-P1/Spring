package com.spring.udemy.restapi.employeecrud.service;

import com.spring.udemy.restapi.employeecrud.dao.EmployeeRepository;
import com.spring.udemy.restapi.employeecrud.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    // Define field for EmployeeDAO
    private final EmployeeRepository employeeRepository;

    // Set up constructor for dependency injection
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Methods
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found! Id - " + id);
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
