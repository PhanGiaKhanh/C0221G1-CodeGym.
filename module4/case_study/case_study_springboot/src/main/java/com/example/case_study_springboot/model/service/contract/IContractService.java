package com.example.case_study_springboot.model.service.contract;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractService extends IGenericService<Contract> {
    Page<Contract> findAllContractUsing(String name, Pageable pageable);
}
