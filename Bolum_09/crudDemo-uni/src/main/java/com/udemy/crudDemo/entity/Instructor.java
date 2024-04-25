package com.udemy.crudDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instructor")
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetailId;

    public Instructor(String firstName, String lastName, String email, InstructorDetail instructorDetailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetailId = instructorDetailId;
    }

    public Instructor() {

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetailId=" + instructorDetailId +
                '}';
    }
}
