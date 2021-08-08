package com.example.productbackend.model.entity.security.reponse;

import com.example.productbackend.model.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private List<String> roles;
    private Employee employee;

    public JwtResponse(String accessToken, Integer id, String username, List<String> roles, Employee employee) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.employee = employee;
    }

    public JwtResponse() {
    }
}
