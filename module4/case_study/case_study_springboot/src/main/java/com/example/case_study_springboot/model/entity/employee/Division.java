package com.example.case_study_springboot.model.entity.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.List;



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

    public Division(Integer id, String divisionName, List<Employee> employees) {
        this.id = id;
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
