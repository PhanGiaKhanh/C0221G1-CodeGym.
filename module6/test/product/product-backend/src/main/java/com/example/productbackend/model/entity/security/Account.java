package com.example.productbackend.model.entity.security;

import com.example.productbackend.model.entity.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String userName;
    private String encryptPw;
    private Boolean isEnabled;
    private String verificationCode;
    private String email;

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Employee employee;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> accountRoleList;

    public Account(String userName, String encryptPw) {
        this.userName = userName;
        this.encryptPw = encryptPw;
    }
}
