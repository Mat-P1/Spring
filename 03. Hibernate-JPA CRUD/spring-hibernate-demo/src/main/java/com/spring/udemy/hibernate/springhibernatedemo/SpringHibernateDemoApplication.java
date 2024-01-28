package com.spring.udemy.hibernate.springhibernatedemo;

import com.spring.udemy.hibernate.springhibernatedemo.dao.StudentDAO;
import com.spring.udemy.hibernate.springhibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create student object
        System.out.println("Creating new student object...");
        Student student = new Student("Paul", "Doe", "paul@gmail.com");

        // Save student object
        System.out.println("Saving new student...");
        studentDAO.create(student);

        // Display student´s id
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // Create multiple students object
        System.out.println("Creating 3 student object...");
        Student student1 = new Student("John", "Doe", "john@gmail.com");
        Student student2 = new Student("Mary", "Public", "mary@gmail.com");
        Student student3 = new Student("Bonita", "Applebaum", "bonita@gmail.com");

        // Save student objects
        System.out.println("Saving the students...");
        studentDAO.create(student1);
        studentDAO.create(student2);
        studentDAO.create(student3);
    }
}
