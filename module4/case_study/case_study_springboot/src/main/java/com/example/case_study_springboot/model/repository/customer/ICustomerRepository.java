package com.example.case_study_springboot.model.repository.customer;

import com.example.case_study_springboot.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
//    @Query(value = "select * from customer where id = 1", nativeQuery = true)
//    Page<Customer> findAllCustomer();
}
