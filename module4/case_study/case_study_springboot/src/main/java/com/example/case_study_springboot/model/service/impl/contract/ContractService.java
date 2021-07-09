package com.example.case_study_springboot.model.service.impl.contract;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.repository.contract.IContractRepository;
import com.example.case_study_springboot.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        Double total = contract.getService().getServiceCost()-contract.getContractDeposit();
        contract.setContractTotalMoney(total);
        contractRepository.save(contract);
    }

    @Override
    public void delete(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllContractUsing(String name, Pageable pageable) {
        return contractRepository.findAllContractUsing(name, pageable);
    }
}
