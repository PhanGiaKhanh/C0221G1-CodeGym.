package com.example.b01_blog_app_springboot.model.entity;

import javax.persistence.*;

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
    @CollectionTable
    private int countLike;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    public Blog() {
    }

    public Blog(String author, String title, String date, String comment) {
        this.author = author;
        this.title = title;
        this.date = date;
        this.comment = comment;
    }

    public Blog(Long id, String author, String title, String date, String comment, int countLike,Category category) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.date = date;
        this.comment = comment;
        this.countLike = countLike;
         this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
