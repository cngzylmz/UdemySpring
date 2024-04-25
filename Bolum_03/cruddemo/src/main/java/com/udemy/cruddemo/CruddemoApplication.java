package com.udemy.cruddemo;

import com.udemy.cruddemo.dao.StudentDAO;
import com.udemy.cruddemo.entitiy.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner ->
                //createStudent(studentDAO);
                createMultipleStudents(studentDAO);
                //readStudent(studentDAO);
                //readAllStudents(studentDAO);
                //readStudentsByLastName(studentDAO);
                //updateStudent(studentDAO);
                //deleteStudent(studentDAO);
                //deleteAllStudent(studentDAO);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println(studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id = 3;
        studentDAO.delete(id);
        System.out.println("Student deleted id :" + id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int id = 3;
        Student student = studentDAO.findById(id);
        student.setFirstName("Updated");
        studentDAO.update(student);
        System.out.println("Student updated" + studentDAO.findById(id));
    }

    private void readStudentsByLastName(StudentDAO studentDAO) {
        studentDAO.findByLastName("Doe1").forEach(System.out::println);
    }

    private void readAllStudents(StudentDAO studentDAO) {
        studentDAO.findAll().forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = new Student("John", "Doe", "");
        studentDAO.save(student);
        int id = student.getId();
        System.out.println("Student created" + id);
        Student studentFromDB = studentDAO.findById(id);
        System.out.println("Student from DB: " + studentFromDB);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student student1 = new Student("John", "Doe", "student@spring.com");
        Student student2 = new Student("John", "Doe", "student@spring.com");
        Student student3 = new Student("John", "Doe", "student@spring.com");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("John", "Doe", "student@spring.com");
        studentDAO.save(student);
        System.out.println("Student created" + student.getId());
    }

}
