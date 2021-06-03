package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    List<String[]> findTypeOfCustomer();

    boolean insertIntoCustomer(Customer customer);

    boolean deleteCustomer(int id);

    Customer findById(int id);

    boolean updateCustomerById(int id, Customer customer);

    List<Customer> searchByName(String name);
}
