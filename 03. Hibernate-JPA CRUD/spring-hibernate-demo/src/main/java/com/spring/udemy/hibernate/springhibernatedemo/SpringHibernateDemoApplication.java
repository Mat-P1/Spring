package com.spring.udemy.hibernate.springhibernatedemo;

import com.spring.udemy.hibernate.springhibernatedemo.dao.StudentDAO;
import com.spring.udemy.hibernate.springhibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            readStudent(studentDAO);
            queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
            updateStudent(studentDAO);
            deleteStudent(studentDAO);
            deleteAllStudents(studentDAO);

        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // Create student object
        System.out.println("Creating new student object...");
        Student student = new Student("Paul", "Doe", "paul@gmail.com");

        // Save student object
        System.out.println("Saving new student...");
        studentDAO.save(student);

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
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void readStudent(StudentDAO studentDAO) {

        // Create a student object
        System.out.println("Creating new student object...");
        Student student = new Student("Daffy", "Duff", "daffy@gmail.com");

        // Save student
        System.out.println("Saving new student...");
        studentDAO.save(student);

        // Display id of saved student
        System.out.println("Saved student. Generated id: " + student.getId());

        // Retrieve student based on id
        System.out.println("Retrieving student with id: " + student.getId());
        Student retievedStudent = studentDAO.findById(student.getId());

        // Display student
        System.out.println("Found student: " + retievedStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // Get a list of students
        List<Student> students = studentDAO.findAll();

        // Display list of students
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // Get a list of students
        List<Student> students = studentDAO.findByLastName("Doe");

        // Display list of students
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {

        // Retrieve student based on id
        int studentId = 1;
        System.out.println("Retrieving student with id: " + studentId);
        Student retievedStudent = studentDAO.findById(studentId);

        // Change first name and email
        System.out.println("Updating student...");
        retievedStudent.setFirstName("Scooby");
        retievedStudent.setEmail("scooby@gmail.com");

        // Update student
        studentDAO.update(retievedStudent);

        // Display updated student
        System.out.println("Updated Student" + retievedStudent);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting student..." + studentId);
        studentDAO.delete(studentId);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students...");
        int numRowsDeleted = studentDAO.deleteAllStudents();
        System.out.println("Deleted rows count: " + numRowsDeleted);
    }
}
