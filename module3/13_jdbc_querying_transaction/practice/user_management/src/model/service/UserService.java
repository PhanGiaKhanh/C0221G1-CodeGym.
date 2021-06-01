package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> findByAll();

    User findById(int id);

    boolean update(int id, User user);

    boolean add(User user);

    boolean remove(int id);

    List<User> sortName();

    List<User> sortCountry();

    //    thuc hanh 1
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    //    thuc hanh 2
    void addUserTransaction(User user, int[] permisions);

    //    thuc hanh 3
    void insertUpdateWithoutTransaction();

    //    thuc hanh 4
    void insertUpdateUseTransaction();
}
