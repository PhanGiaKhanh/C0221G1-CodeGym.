package com.example.case_study_springboot.model.repository.customer;

import com.example.case_study_springboot.model.entity.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {
}
