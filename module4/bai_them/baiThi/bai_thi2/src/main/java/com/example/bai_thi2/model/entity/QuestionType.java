package com.example.bai_thi2.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "questionType")
    private List<Question> questionList;
}
