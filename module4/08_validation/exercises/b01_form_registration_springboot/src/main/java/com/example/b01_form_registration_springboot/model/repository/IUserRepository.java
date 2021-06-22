package com.example.b01_form_registration_springboot.model.repository;

import com.example.b01_form_registration_springboot.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
