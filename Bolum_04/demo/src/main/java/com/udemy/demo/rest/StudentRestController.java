package com.udemy.demo.rest;

import com.udemy.demo.entitiy.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> list;

    @PostConstruct
    public void loadData() {
        list = new ArrayList<>();
        list.add(new Student("first", "student1"));
        list.add(new Student("second", "student2"));
        list.add(new Student("third", "student3"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= list.size() || studentId < 0) {
            throw new StudentNotFoundException("student id not found : " + studentId);
        }

        return list.get(studentId);
    }
}
