package com.example.case_study_springboot.model.repository.contract;

import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail, Integer> {
    @Query(value = "select id, sum(quantity) as quantity, attach_service_id, contract_id " +
            "from contract_detail group by attach_service_id",nativeQuery = true)
    List<ContractDetail> findAllByContractDetailByAttachService();
}
