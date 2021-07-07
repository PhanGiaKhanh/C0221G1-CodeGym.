package com.example.case_study_springboot.model.entity.user;

import com.example.case_study_springboot.model.entity.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;
    @OneToMany(mappedBy = "user")
    private List<Employee> employeeList;

    public User() {
    }
}
