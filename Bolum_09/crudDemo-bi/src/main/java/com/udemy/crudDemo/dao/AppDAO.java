package com.udemy.crudDemo.dao;

import com.udemy.crudDemo.entity.Instructor;
import com.udemy.crudDemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
