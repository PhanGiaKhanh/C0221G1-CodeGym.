package com.example.case_study_springboot.model.service.impl.customer;

import com.example.case_study_springboot.model.entity.customer.CustomerType;
import com.example.case_study_springboot.model.repository.customer.ICustomerTypeRepository;
import com.example.case_study_springboot.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void delete(Integer id) {

    }
}
