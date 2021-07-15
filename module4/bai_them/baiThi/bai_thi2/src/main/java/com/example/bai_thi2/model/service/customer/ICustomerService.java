package com.example.bai_thi2.model.service.customer;

import com.example.bai_thi2.model.entity.customer.Customer;
import com.example.bai_thi2.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGenericService<Customer> {
    Page<Customer> findAllCustomer(@Param("keySearch") String keySearch, Pageable pageable);
    Page<Customer> findAllCustomerUsing(String keySearch, Pageable pageable);
    Page<Customer> findAllNameGenderBirthday(String keyName, String keyGender, String keyBirthday, Pageable pageable);

}
