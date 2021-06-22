package com.example.customer_management.model.service;

import com.example.customer_management.model.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    // thực hành 1
//        Iterable<Customer> findAllByProvince(Province province);
    // thực hành 2

    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
