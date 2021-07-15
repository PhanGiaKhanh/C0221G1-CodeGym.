package com.example.case_study_springboot.model.repository.customer;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    @Query(value = "select * from customer c " +
            "where  (c.customer_name like %?1%) " +
            "and (c.customer_gender like %?2%) " +
            "and (c.customer_birthday like %?3%) " +
            "and (customer_flag = 1)" +
            "order by id desc ", nativeQuery = true)
    Page<Customer> findAllNameGenderBirthday(String keyName, String keyGender, String keyBirthday, Pageable pageable);


    @Query(value = "select * from customer where (customer_flag = 1) " +
            "AND  (concat(customer_name,' ', customer_phone) like :keySearch) " +
            "order by id desc", nativeQuery = true)
    Page<Customer> findAllCustomer(@Param("keySearch") String keySearch, Pageable pageable);
    @Query(value = "select * from customer c join contract con on c.id = con.customer_id " +
            "where (curdate() between start_date and end_date) " +
            "and (c.customer_name like %?1%) " +
            "and (customer_flag = 1)" +
            "order by id desc ", nativeQuery = true)
    Page<Customer> findAllCustomerUsing(String keySearch, Pageable pageable);
}
