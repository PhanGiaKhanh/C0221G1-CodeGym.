package com.example.bai_thi2.model.repository.customer;

import com.example.bai_thi2.model.entity.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {
}
