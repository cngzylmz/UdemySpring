package com.udemy.crudDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instructor_detail")
@Data
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    private String hobby;

    public InstructorDetail(){}

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
