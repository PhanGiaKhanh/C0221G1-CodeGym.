package model.service.impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.common.Regex;
import model.common.Validate;
import model.repository.CustomerRepository;
import model.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    Validate validate = new Validate();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllCustomer();
    }
    @Override
    public List<CustomerType> findType(){
        return customerRepository.findType();
    }

    @Override
    public Customer findByCode(String code) {
        return customerRepository.findByCode(code);
    }

    @Override
    public List<String> insertIntoCustomer(Customer customer){
        List<String> errList = new ArrayList<>();
        errList.add(Validate.checkCustomerId(customer.getCode()));
        errList.add(Validate.checkName(customer.getName()));
        errList.add(Validate.checkPhoneNumber(customer.getPhone()));
        errList.add(Validate.checkIdCard(customer.getIdCard()));
        errList.add(Validate.checkName(customer.getAddress()));
        errList.add(Validate.checkEmail(customer.getEmail()));
        errList.add(Validate.checkDay(customer.getBirthday()));
        boolean checkFull = false;
        for (String s : errList) {
            if (s != null){
                checkFull = true;
                break;
            }
        }
        if (!checkFull) {
            customerRepository.insertIntoCustomer(customer);
        }
        return errList;
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
