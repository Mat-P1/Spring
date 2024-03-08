package com.spring.udemy.advancedmappings.hibernatejpacrud.dao;

import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
