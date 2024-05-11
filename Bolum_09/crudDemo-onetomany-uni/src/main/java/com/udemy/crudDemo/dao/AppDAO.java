package com.udemy.crudDemo.dao;

import com.udemy.crudDemo.entity.Course;
import com.udemy.crudDemo.entity.Instructor;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);
    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save (Course course);

    Course findCourseAndReviewsByCourseId(int id);

}
