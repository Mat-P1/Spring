package com.spring.udemy.aop.aopmvccrud.service;

import com.spring.udemy.aop.aopmvccrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
