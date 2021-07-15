package com.example.case_study_springboot.model.service.customer;

import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGenericService<Customer> {
    Page<Customer> findAllCustomer(@Param("keySearch") String keySearch, Pageable pageable);
    Page<Customer> findAllCustomerUsing(String keySearch, Pageable pageable);
    Page<Customer> findAllNameGenderBirthday(String keyName, String keyGender, String keyBirthday, Pageable pageable);

}
