package com.spring.udemy.advancedmappings.hibernatejpacrud.dao;

import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Instructor;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.InstructorDetail;
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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        // Retrieve instructor detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // Remove associated object reference and break bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        // Delete instructor detail
        entityManager.remove(instructorDetail);
    }
}
