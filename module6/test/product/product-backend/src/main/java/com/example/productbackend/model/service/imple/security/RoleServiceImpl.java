package com.example.productbackend.model.service.imple.security;

import com.example.productbackend.model.entity.security.Role;
import com.example.productbackend.model.repository.IRoleRepository;
import com.example.productbackend.model.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    /**
     *Nguyen Van Linh
     */
    @Override
    public void setDefaultRole(int accountId, Integer roleId) {
        roleRepository.setDefaultRole(accountId,roleId);
    }
    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public List< Role> getAllRoles() {
        return roleRepository.finAllRole();

    }
}
