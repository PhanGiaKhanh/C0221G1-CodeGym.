package com.example.case_study_springboot.model.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "roleId")
    private Role role;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    public UserRole() {
    }
}
