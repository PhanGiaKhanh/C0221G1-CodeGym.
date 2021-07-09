package com.example.case_study_springboot.model.repository.contract;

import com.example.case_study_springboot.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends PagingAndSortingRepository<Contract, Integer> {
    @Query(value = "select *" +
            " from contract  " +
            "join customer on contract.customer_id=customer.id " +
            "where (curdate() between start_date and end_date) " +
            "and (customer.customer_name like %?1%) " +
            "and (contract.contract_flag = 1) " +
            "order by contract.id desc",nativeQuery = true)
    Page<Contract> findAllContractUsing(String name, Pageable pageable);
}
