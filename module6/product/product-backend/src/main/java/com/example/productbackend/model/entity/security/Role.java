package com.example.productbackend.model.entity.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String name;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private Set<AccountRole> accountRoleList;

}
