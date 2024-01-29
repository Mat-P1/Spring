package com.spring.udemy.hibernate.springhibernatedemo.dao;

import com.spring.udemy.hibernate.springhibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById (Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update (Student student);
    void delete (Integer id);
    int deleteAllStudents();
}
