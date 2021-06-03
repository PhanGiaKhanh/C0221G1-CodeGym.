package model.service;

import model.bean.Customer;

import java.util.List;

public interface Service<E> {
    List<E> findAll();

    List<String[]> findType();

    boolean insertIntoCustomer(E e);

    boolean deleteCustomer(int id);

    Customer findById(int id);

    boolean updateById(int id, E e);

    List<E> searchByName(String name);
}
