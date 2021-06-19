package com.model.bean;

import javax.persistence.*;

@Entity
@Table (name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String comment;
    private int countLike;
    private int id_blog;


    public Comment() {
    }

    public Comment(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }


    public Comment(Long id, String author, String comment, int countLike, int id_blog) {
        this.id = id;
        this.author = author;
        this.comment = comment;
        this.countLike = countLike;
        this.id_blog = id_blog;
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

    public int getId_blog() {
        return id_blog;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }
}
