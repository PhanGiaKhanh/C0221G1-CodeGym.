package model.service;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    boolean insertIntoCustomer(Customer customer);

    boolean deleteCustomer(int id);

    Customer findById(int id);

    boolean updateById(int id, Customer customer);

    List<Customer> searchByName(String name);
    List<CustomerType> findType();
}
