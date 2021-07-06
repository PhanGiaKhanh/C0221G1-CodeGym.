package com.example.case_study_springboot.model.service.impl.customer;

import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.repository.customer.ICustomerRepository;
import com.example.case_study_springboot.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(String keySearch, Pageable pageable) {
        return customerRepository.findAllCustomer("%"+ keySearch +"%", pageable);
    }
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }


}
