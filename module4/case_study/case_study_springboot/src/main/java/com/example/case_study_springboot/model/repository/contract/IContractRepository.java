package com.example.case_study_springboot.model.repository.contract;

import com.example.case_study_springboot.model.entity.contract.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IContractRepository extends PagingAndSortingRepository<Contract, Integer> {
}
