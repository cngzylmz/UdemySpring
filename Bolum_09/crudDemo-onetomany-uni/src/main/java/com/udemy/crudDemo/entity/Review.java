package com.udemy.crudDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    public Review(String comment) {
        this.comment = comment;
    }

    public Review() {

    }
}
