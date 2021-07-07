package com.example.case_study_springboot.model.service.impl.contract;

import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import com.example.case_study_springboot.model.repository.contract.IContractDetailRepository;
import com.example.case_study_springboot.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Integer id) {
        contractDetailRepository.deleteById(id);
    }
}
