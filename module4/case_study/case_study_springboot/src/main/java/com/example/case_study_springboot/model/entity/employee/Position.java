package com.example.case_study_springboot.model.entity.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String positionName;
    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    public Position() {
    }

    public Position(Integer id, String positionName, List<Employee> employees) {
        this.id = id;
        this.positionName = positionName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
