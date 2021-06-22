package com.example.b02_img_of_day_springboot.model.entity;

import javax.persistence.*;

@Entity(name = "comments")

public class Comment implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int start;
    private String author;
    private String feedback;
    @Column(name = "count_like")
    private int countLike;

    public Comment() {
    }

    public Comment(int start, String author, String feedback) {
        this.start = start;
        this.author = author;
        this.feedback = feedback;
    }

    public Comment(Long id, int start, String author, String feedback, int countLike) {
        this.id = id;
        this.start = start;
        this.author = author;
        this.feedback = feedback;
        this.countLike = countLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }
}
