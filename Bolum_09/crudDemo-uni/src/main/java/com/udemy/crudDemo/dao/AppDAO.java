package com.udemy.crudDemo.dao;

import com.udemy.crudDemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
