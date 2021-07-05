package com.example.case_study_springboot.model.entity.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String degreeName;
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(Integer id, String degreeName, List<Employee> employees) {
        this.id = id;
        this.degreeName = degreeName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
