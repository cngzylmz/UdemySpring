package com.udemy.crudDemo;

import com.udemy.crudDemo.dao.AppDAO;
import com.udemy.crudDemo.entity.Course;
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
            //deleteInstructor(appDAO);

            //createInstructorWithCourses(appDAO);
            //findInstructorWithCourses(appDAO);
            //findCoursesForInstructor(appDAO);
            //findInstructorWithFetch(appDAO);
            //updateInstructor(appDAO);
            //updateCourse(appDAO);
            deleteCourseById(appDAO);
        };


    }

    private void deleteCourseById(AppDAO appDAO) {
        appDAO.deleteCourseById(10);
    }

    private void updateCourse(AppDAO appDAO) {
        Course tempCourse = appDAO.findCourseById(10);
        tempCourse.setTitle("BEN COK DEGISTIM");
        appDAO.update(tempCourse);
    }

    private void updateInstructor(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(1);
        instructor.setFirstName("TEST");
        appDAO.update(instructor);
        System.out.println(instructor.getFirstName());
    }

    private void findInstructorWithFetch(AppDAO appDAO) {
        System.out.println(appDAO.findInstructorByIdJoinFetch(1).getCourses().size());
        System.out.println(appDAO.findInstructorByIdJoinFetch(1).getInstructorDetail());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        System.out.println(appDAO.findInstructorByIdJoinFetch(1).getCourses().size());


    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        System.out.println(appDAO.findInstructorById(1).getCourses().get(1).getTitle());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        InstructorDetail tempInstructorDetail = new InstructorDetail("channel2", "nothing");

        Instructor tempInstructor = new Instructor("test", "yilmaz", "qweq@weq.com", tempInstructorDetail);

        Course tempCourse1 = new Course("first course");
        Course tempCourse2 = new Course("second course");
        Course tempCourse3 = new Course("third course");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);

        appDAO.save(tempInstructor);

        System.out.println("DONE");
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
