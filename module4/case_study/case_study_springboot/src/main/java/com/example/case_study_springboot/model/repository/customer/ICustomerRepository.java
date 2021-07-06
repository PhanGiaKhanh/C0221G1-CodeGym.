package com.example.case_study_springboot.model.repository.customer;

import com.example.case_study_springboot.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    @Query(value = "select * from customer where (customer_flag = 1) " +
            "AND  (concat(customer_name,' ', customer_phone) like :keySearch) " +
            "order by id desc", nativeQuery = true)
    Page<Customer> findAllCustomer(@Param("keySearch") String keySearch, Pageable pageable);
//    @Query(value = "select * from product where concat(`name`, `date`) like :keySearch order by `date` desc", nativeQuery = true)
//    Page<Product> searchNameAndDate(@Param("keySearch") String keySearch, Pageable pageable);
}
