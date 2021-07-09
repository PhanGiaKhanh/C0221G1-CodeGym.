package com.example.case_study_springboot.model.service.employee.security;


import com.example.case_study_springboot.model.entity.user.AppUser;
import com.example.case_study_springboot.model.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole>  findByAppUser(AppUser appUser);
}
