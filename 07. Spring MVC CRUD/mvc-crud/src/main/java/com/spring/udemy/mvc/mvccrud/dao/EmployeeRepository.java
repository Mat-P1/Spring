package com.spring.udemy.mvc.mvccrud.dao;

import com.spring.udemy.mvc.mvccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /*
     * JpaRepository Interface offer several pre-build CRUD features and methods including things like @Transactional
     * annotations and findAll() or findById() methods
     */

    // Custom method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();
}
