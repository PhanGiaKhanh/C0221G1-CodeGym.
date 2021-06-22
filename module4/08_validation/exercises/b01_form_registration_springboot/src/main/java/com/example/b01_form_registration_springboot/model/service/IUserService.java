package com.example.b01_form_registration_springboot.model.service;


import com.example.b01_form_registration_springboot.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);
}
