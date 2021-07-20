package com.example.bai_thi2.model.service.impl;

import com.example.bai_thi2.model.entity.User;
import com.example.bai_thi2.model.repository.IUserRepository;
import com.example.bai_thi2.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
