package com.example.case_study_springboot.model.service.employee.security;


import com.example.case_study_springboot.model.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);

}
