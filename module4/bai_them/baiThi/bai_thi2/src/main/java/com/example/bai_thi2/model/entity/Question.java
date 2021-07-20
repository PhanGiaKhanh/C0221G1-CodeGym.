package com.example.bai_thi2.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String question;
    private String answer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private QuestionType questionType;
    private String dateCreate;
    private String status;
    private Boolean flag;
}
