package com.example.productbackend.model.service;

import com.example.productbackend.model.entity.security.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRole();
    void setDefaultRole(int accountId, Integer roleId);
    List<Role> getAllRoles();
}
