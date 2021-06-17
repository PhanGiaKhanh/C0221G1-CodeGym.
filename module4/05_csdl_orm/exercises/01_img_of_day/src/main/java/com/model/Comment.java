package com.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int start;
    private String name;
    private String feedback;

    public Comment() {
    }

    public Comment(int start, String name, String feedback) {
        this.start = start;
        this.name = name;
        this.feedback = feedback;
    }

    public Comment(Long id, int start, String name, String feedback) {
        this.id = id;
        this.start = start;
        this.name = name;
        this.feedback = feedback;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
