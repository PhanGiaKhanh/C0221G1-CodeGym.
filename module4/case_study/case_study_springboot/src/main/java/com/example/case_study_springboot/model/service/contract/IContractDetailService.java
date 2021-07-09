package com.example.case_study_springboot.model.service.contract;

import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import com.example.case_study_springboot.model.service.IGenericService;

import java.util.List;

public interface IContractDetailService extends IGenericService<ContractDetail> {
    List<ContractDetail> findAllByContractDetailByAttachService();
}
