package com.example.case_study_springboot.model.repository.contract;

import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail, Integer> {
}
