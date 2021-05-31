package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.service.UserService;

import java.util.List;

public class UserImpl implements UserService {
    UserRepository userRepository = new UserRepository();
    @Override
    public List<User> findByAll() {
        return userRepository.findByAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean update(int id, User user) {
        return userRepository.update(id, user);
    }

    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    @Override
    public List<User> sortName() {
        return userRepository.sortName();
    }

    @Override
    public List<User> sortCountry() {
        return userRepository.sortCountry();
    }
}
