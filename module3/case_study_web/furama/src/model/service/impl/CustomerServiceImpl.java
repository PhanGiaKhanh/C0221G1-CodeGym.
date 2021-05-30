package model.service.impl;

import model.bean.Customer;
import model.reponsitory.CustomerRepository;
import model.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customers = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customers.findAll();
    }

    @Override
    public void save(Customer customer) {
        customers.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    @Override
    public int getSize() {
        return customers.getSize();
    }

    @Override
    public List<Customer> findByName(String name) {
        return  customers.findByName(name);
    }
}
