package com.spring.udemy.restapi.employeecrud.dao;

import com.spring.udemy.restapi.employeecrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    // Define field for Entity Manager
    private final EntityManager entityManager;

    // Set up constructor for dependency injection
    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Methods
    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> findAllQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute query and return results
        return findAllQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {

        // GET and return employee
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {

        // Insert/Update and return Employee
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

        // Find employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // Remove employee
        entityManager.remove(employee);
    }
}
