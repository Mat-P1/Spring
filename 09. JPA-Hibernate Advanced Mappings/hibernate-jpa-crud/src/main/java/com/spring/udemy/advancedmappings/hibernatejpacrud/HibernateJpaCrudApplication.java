package com.spring.udemy.advancedmappings.hibernatejpacrud;

import com.spring.udemy.advancedmappings.hibernatejpacrud.dao.AppDAO;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Course;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Instructor;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.InstructorDetail;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        // First create instructor then test the other methods

        return runner ->
                /** Bidirectional */

                // createInstructor(appDAO);
                // findInstructor(appDAO);
                // deleteInstructor(appDAO);
                // findInstructorDetail(appDAO);
                // deleteInstructorDetail(appDAO);
                // createInstructorWithCourses(appDAO);
                // findInstructorWithCourses(appDAO);
                // findCoursesForInstructor(appDAO);
                // findInstructorWithCoursesJoinFetch(appDAO);
                // updateInstructor(appDAO);
                // updateCourse(appDAO);
                // deleteCourse(appDAO);

                /** Unidirectional */

                // createCourseAndReviews(appDAO);
                // retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);
    }

    private void createInstructor(AppDAO appDAO) {

        // Create instructor
        Instructor instructor1 = new Instructor("Roy", "Mustang", "roy@email.com");
        Instructor instructor2 = new Instructor("Edward", "Elric", "ed@email.com");
        Instructor instructor3 = new Instructor("Alphonse", "Elric", "al@email.com");

        // Create instructor details
        InstructorDetail instructorDetail1 = new InstructorDetail("https://www.youtube.com/roy", "Kotlin");
        InstructorDetail instructorDetail2 = new InstructorDetail("https://www.youtube.com/edw", "Java");
        InstructorDetail instructorDetail3 = new InstructorDetail("https://www.youtube.com/alp", "Python");

        // Associate objects
        instructor1.setInstructorDetail(instructorDetail1);
        instructor2.setInstructorDetail(instructorDetail2);
        instructor3.setInstructorDetail(instructorDetail3);

        // Save instructor. This will also save details and courses because CascadeType.PERSIST
        System.out.println("Saving instructor: " + instructor1 + "\n" + instructor2 + "\n" + instructor3);
        appDAO.save(instructor1);
        appDAO.save(instructor2);
        appDAO.save(instructor3);
        System.out.println("...done");
    }

     private void findInstructor(AppDAO appDAO) {

        int id = 2;

        System.out.println("Finding instructor id: " + id);

        Instructor tempInstructor = appDAO.findInstructorById(id);

        System.out.println("Instructor: " + tempInstructor + "/nDetails: " + tempInstructor.getInstructorDetail());
    }

    private void deleteInstructor(AppDAO appDAO) {

        int id = 3;
        System.out.println("Deleting instructor id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("Done. Instructor deleted.");
    }

    private void findInstructorDetail(AppDAO appDAO) {

        // Get instructor detail object
        int id = 1;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

        // print instructor detail
        System.out.println("Instructor Detail: " + instructorDetail);

        // print associated instructor
        System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
        System.out.println("Done...!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int id = 3;
        System.out.println("Deleting instructor detail id: " + id);

        appDAO.deleteInstructorDetailById(id);

        System.out.println("Done. Instructor's details deleted.");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        // Create instructor
        Instructor instructor4 = new Instructor("Mat", "Mustang", "mat@email.com");
        Instructor instructor5 = new Instructor("Roy", "Elric", "ed@email.com");
        Instructor instructor6 = new Instructor("Alfred", "Elric", "al@email.com");

        // Create instructor details
        InstructorDetail instructorDetail4 = new InstructorDetail("https://www.youtube.com/mat", "Kotlin");
        InstructorDetail instructorDetail5 = new InstructorDetail("https://www.youtube.com/roy", "Java");
        InstructorDetail instructorDetail6 = new InstructorDetail("https://www.youtube.com/alf", "Python");

        // Associate objects
        instructor4.setInstructorDetail(instructorDetail4);
        instructor5.setInstructorDetail(instructorDetail5);
        instructor6.setInstructorDetail(instructorDetail6);

        // Create some courses
        Course course1 = new Course("OOP");
        Course course2 = new Course("Data Structures");
        Course course3 = new Course("Agile");
        Course course4 = new Course("Paradigms");
        Course course5 = new Course("Algorithms");
        Course course6 = new Course("Statistics");

        // Add course to instructor
        instructor4.addCourse(course1);
        instructor4.addCourse(course2);
        instructor5.addCourse(course3);
        instructor5.addCourse(course4);
        instructor6.addCourse(course5);
        instructor6.addCourse(course6);

        // Save instructor. This will also save details and courses because CascadeType.PERSIST
        System.out.println("Saving instructor with courses: " + instructor4 + "\n" + instructor4.getCourses()
        + "\n" + instructor5 + "\n" + instructor5.getCourses() + "\n" + instructor6 + "\n" + instructor6.getCourses());
        appDAO.save(instructor4);
        appDAO.save(instructor5);
        appDAO.save(instructor6);
        System.out.println("...done");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int id = 1;
        System.out.println("Finding instructor with courses: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor + "\nCourses: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {

        int id = 1;
        System.out.println("Finding instructor with courses: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);

        // Find courses for instructor
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);
        System.out.println("Associated courses: " + instructor.getCourses());
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

        int id = 1;
        System.out.println("Finding instructor with courses: " + id);

        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("Instructor: " + instructor);

        System.out.println("Associated courses: " + instructor.getCourses());
    }

    private void updateInstructor(AppDAO appDAO) {

        int id = 1;

        // Find instructor
        System.out.println("Finding instructor: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);

        // Update data
        System.out.println("Updating instructor...");
        instructor.setLastName("Roy");
        instructor.setEmail("roy@email.com");

        // Update instructor with Merge
        appDAO.update(instructor);

        System.out.println("Instructor updated...");
        System.out.println(instructor);
    }

    private void updateCourse(AppDAO appDAO) {

        int id = 1;

        // Find instructor
        System.out.println("Finding course: " + id);
        Course course = appDAO.findCourseById(id);
        System.out.println(course);

        // Update data
        System.out.println("Updating course...");
        course.setTitle("Programming Paradigms");

        // Update instructor with Merge
        appDAO.update(course);

        System.out.println("Course updated...");
        System.out.println(course);
    }

    private void deleteCourse(AppDAO appDAO) {

        int id = 1;

        System.out.println("Deleting course: " + id);
        appDAO.deleteCourseById(id);
        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {

        // Create course
        Course course = new Course("Object-Oriented Programming");

        // Add reviews
        course.addReview(new Review("Great course. Loved it."));
        course.addReview(new Review("Cool course, job well done."));
        course.addReview(new Review("What a dumb course."));

        // Save course and leverage cascade.all
        System.out.println("Saving course...");
        System.out.println(course);
        System.out.println(course.getReviews());
        appDAO.save(course);
        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        // Get course and reviews
        int id = 1;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);

        System.out.println("Course: " + course);
        System.out.println("Reviews " + course.getReviews());
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int id = 1;
        
        System.out.println("Deleting course: " + id);
        appDAO.deleteCourseById(id);
        System.out.println("Done!");
    }
}
