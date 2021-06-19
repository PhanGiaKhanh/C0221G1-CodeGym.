package com.model.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "blogs")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Long id;
    private String author;
    private String title;
    private String date;
    private String comment;
    private int countLike;

    public Blog() {
    }

    public Blog(String author, String title, String date, String comment) {
        this.author = author;
        this.title = title;
        this.date = date;
        this.comment = comment;
    }

    public Blog(Long id, String author, String title, String date, String comment, int countLike) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.date = date;
        this.comment = comment;
        this.countLike = countLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }
}
