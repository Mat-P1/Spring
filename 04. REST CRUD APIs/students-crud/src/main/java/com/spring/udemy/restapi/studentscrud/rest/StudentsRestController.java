package com.spring.udemy.restapi.studentscrud.rest;

import com.spring.udemy.restapi.studentscrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsRestController {

    private List<Student> students;

    // Define @PostConstruct to load student data only once

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Nima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Marry", "Smith"));
    }

    // Define GET endpoint for "/students"
    // Retrieve all students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // Define GET endpoint for "/students/{studentId}"
    // Retrieve a single student by index

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // Check if the student exists

        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }
}
