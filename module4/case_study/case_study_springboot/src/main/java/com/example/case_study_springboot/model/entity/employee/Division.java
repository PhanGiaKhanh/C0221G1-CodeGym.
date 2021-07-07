package com.example.case_study_springboot.model.entity.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String divisionName;
    @OneToMany(mappedBy = "division")
    private List<Employee> employees;

    public Division() {
    }
}
