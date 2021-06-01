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

    @Override
    public List<User> searchName(String search) {
        return userRepository.searchName(search);
    }

    @Override
    public List<User> get_by_all(){
        return userRepository.get_by_all();
    }

    @Override
    public boolean insert_user(int id, User user) {
        return userRepository.insert_user(id,  user);
    }

    @Override
    public boolean delete_user(int id) {
        return userRepository.delete_user(id);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user, permision);
    }


}
