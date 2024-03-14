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
        // First create instructor then test the other methods
        return runner ->  createInstructor(appDAO);
                         // findInstructor(appDAO);
                         // deleteInstructor(appDAO);
                         // findInstructorDetail(appDAO);
                         //  deleteInstructorDetail(appDAO);
    }

    private void createInstructor(AppDAO appDAO) {

        // Create instructor
        Instructor instructor1 = new Instructor("Roy", "Mustang", "mat@email.com");
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

        // Save instructor. This will also dave details object because CascadeType.ALL
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
}
