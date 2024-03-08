package com.spring.udemy.advancedmappings.hibernatejpacrud;

import com.spring.udemy.advancedmappings.hibernatejpacrud.dao.AppDAO;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.Instructor;
import com.spring.udemy.advancedmappings.hibernatejpacrud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> createInstructor(appDAO);
                         // findInstructor(appDAO);
                         // deleteInstructor(appDAO);
    }

     private void createInstructor(AppDAO appDAO) {

        // Create instructor
        Instructor tempInstructor = new Instructor("Matt", "Pine", "mat@email.com");

        // Create instructor details
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.udemy.com/youtube", "Java");

        // Associate objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // Save instructor. This will also dave details object because CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("...done");
    }

     private void findInstructor(AppDAO appDAO) {

        int id = 1;

        System.out.println("Finding instructor id: " + id);

        Instructor tempInstructor = appDAO.findInstructorById(id);

        System.out.println("Instructor: " + tempInstructor + "/nDetails: " + tempInstructor.getInstructorDetail());
    }

    private void deleteInstructor(AppDAO appDAO) {

        int id = 1;
        System.out.println("Deleting instructor id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("Done. Instructor deleted.");
    }
}
