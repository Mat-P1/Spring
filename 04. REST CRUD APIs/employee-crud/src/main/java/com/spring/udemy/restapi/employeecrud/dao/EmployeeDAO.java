package com.spring.udemy.restapi.employeecrud.dao;

import com.spring.udemy.restapi.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
