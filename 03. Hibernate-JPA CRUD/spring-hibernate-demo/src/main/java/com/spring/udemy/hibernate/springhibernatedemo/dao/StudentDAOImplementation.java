package com.spring.udemy.hibernate.springhibernatedemo.dao;

import com.spring.udemy.hibernate.springhibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    // Define field for entity manager
    private final EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implements create/save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // Implements find method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // Implements find all method
    @Override
    public List<Student> findAll() {

        // Create query
        TypedQuery<Student> findQuery = entityManager
                .createQuery("FROM Student", Student.class);

        // Return query results
        return findQuery.getResultList();
    }

    // Implements find by last method
    @Override
    public List<Student> findByLastName(String lastName) {

        // Create query
        TypedQuery<Student> findQuery = entityManager
                .createQuery("FROM Student WHERE lastName = :data", Student.class);

        // Set query parameters
        findQuery.setParameter("data", lastName);

        // Return query results
        return findQuery.getResultList();
    }

    // Implements update method
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    // Implements delete method
    @Override
    @Transactional
    public void delete(Integer id) {

        // Retrieve student
        Student student = entityManager.find(Student.class, id);

        // Delete student
        entityManager.remove(student);
    }

    // Implements delete all method
    @Override
    @Transactional
    public int deleteAllStudents() {
        int numRowsDeleted = entityManager
                .createQuery("DELETE FROM Student")
                .executeUpdate();
        return numRowsDeleted;
    }
}
