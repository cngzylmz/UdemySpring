package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entitiy.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);
    int deleteAll();
}
