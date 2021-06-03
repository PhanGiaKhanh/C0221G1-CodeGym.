package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.Service;

import java.util.List;

public class CustomerServiceImpl implements Service<Customer> {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllCustomer();
    }
    @Override
    public List<String[]> findType(){
        return customerRepository.findAllNameTypeCustomer();
    }
    @Override
    public boolean insertIntoCustomer(Customer customer){
        return customerRepository.insertIntoCustomer(customer);
    }
    @Override
    public boolean deleteCustomer(int id){
        return customerRepository.deleteCustomer(id);
    }
    @Override
    public Customer findById(int id){
        return customerRepository.findById(id);
    }
    @Override
    public boolean updateById(int id, Customer customer){
        return customerRepository.updateCustomerById(id,customer);
    }
    @Override
    public List<Customer> searchByName(String name){
        return customerRepository.searchByName(name);
    }
}
