package com.spring.udemy.hibernate.springhibernatedemo.dao;

import com.spring.udemy.hibernate.springhibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implements create/save method
    @Override
    @Transactional
    public void create(Student student) {
        entityManager.persist(student);
    }
}
