package com.spring.udemy.restapi.employeecrud.service;

import com.spring.udemy.restapi.employeecrud.dao.EmployeeDAO;
import com.spring.udemy.restapi.employeecrud.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    // Define field for EmployeeDAO
    private final EmployeeDAO employeeDAO;

    // Set up constructor for dependency injection
    public EmployeeServiceImplementation(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // Methods
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
