package com.spring.udemy.mvc.mvccrud.service;

import com.spring.udemy.mvc.mvccrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
