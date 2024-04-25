package com.udemy.crudDemo;

import com.udemy.crudDemo.dao.AppDAO;
import com.udemy.crudDemo.entity.Instructor;
import com.udemy.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            deleteInstructor(appDAO);
        };


    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorById(id);
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor temp = appDAO.findInstructorById(id);
        System.out.println(temp);
    }

    public void createInstructor(AppDAO appDAO) {

        InstructorDetail tempInstructorDetail = new InstructorDetail("channel2", "nothing");

        Instructor tempInstructor = new Instructor("test", "yilmaz", "qweq@weq.com", tempInstructorDetail);

        System.out.println(tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("DONE");
    }
}
