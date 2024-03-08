package com.spring.udemy.advancedmappings.hibernatejpacrud.dao;

import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImplementation implements AppDAO {

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        // Retrieve instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // Delete instructor
        entityManager.remove(instructor);
    }
}
