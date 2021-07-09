package com.example.case_study_springboot.model.entity.employee;

import com.example.case_study_springboot.model.entity.contract.Contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private String birthday;
    @Column(nullable = false)
    private String salary;
    @Column(nullable = false)
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Division division;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Position position;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;
    private Boolean flag;

    public Employee() {
    }

}
