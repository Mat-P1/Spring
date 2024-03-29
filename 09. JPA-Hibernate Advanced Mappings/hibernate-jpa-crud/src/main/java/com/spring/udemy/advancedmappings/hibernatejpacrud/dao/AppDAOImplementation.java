package com.spring.udemy.advancedmappings.hibernatejpacrud.dao;

import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Course;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Instructor;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.InstructorDetail;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        // Get courses
        List<Course> courses = instructor.getCourses();

        // Remove association between courses and instructor
        for (Course course : courses) {
            course.setInstructor(null);
        }

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

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        // Create query
        TypedQuery<Course> findCoursesByInstructorIdQuery = entityManager.createQuery(
                        "FROM Course WHERE instructor.id = :data", Course.class);
        findCoursesByInstructorIdQuery.setParameter("data", id);

        // Execute query
        return findCoursesByInstructorIdQuery.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        // Create query
        TypedQuery<Instructor> findInstructorByIdJoinFetchQuery = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                   "JOIN FETCH i.courses " +
                   "JOIN FETCH i.instructorDetail " +
                   "WHERE i.id = :data", Instructor.class);
        findInstructorByIdJoinFetchQuery.setParameter("data", id);

        // Execute query
        return findInstructorByIdJoinFetchQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        // Retrieve course
        Course course = entityManager.find(Course.class, id);

        // Delete course
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        // Create query
        TypedQuery<Course> findCourseAndReviewsByCourseIdQuery = entityManager.createQuery(
                "SELECT c FROM Course c " +
                   "JOIN FETCH c.reviews " +
                   "WHERE c.id = :data", Course.class
        );

        findCourseAndReviewsByCourseIdQuery.setParameter("data", id);

        // Execute query
        return findCourseAndReviewsByCourseIdQuery.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {

        // Create query
        TypedQuery<Course> findCourseAndStudentsByCourseIdQuery = entityManager.createQuery(
                "SELECT c FROM Course c " +
                   "JOIN FETCH c.students " +
                   "WHERE c.id = :data", Course.class
        );

        findCourseAndStudentsByCourseIdQuery.setParameter("data", id);

        // Execute Query
        return findCourseAndStudentsByCourseIdQuery.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {

        // Create query
        TypedQuery<Student> findStudentAndCoursesByStudentIdQuery = entityManager.createQuery(
                "SELECT s FROM Student s " +
                   "JOIN FETCH s.courses " +
                   "WHERE s.id = :data", Student.class
        );

        findStudentAndCoursesByStudentIdQuery.setParameter("data", id);

        // Execute Query
        return findStudentAndCoursesByStudentIdQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        // Retrieve student
        Student student = entityManager.find(Student.class, id);

        // Delete student
        entityManager.remove(student);
    }
}
