package com.model.service;

import com.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);
}
