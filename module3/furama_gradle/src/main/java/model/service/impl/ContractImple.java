package model.service.impl;

import model.bean.contract.Contract;
import model.repository.ContractRepository;
import model.service.ContractService;

import java.util.List;

public class ContractImple implements ContractService {
    ContractRepository contractRepository = new ContractRepository();

    @Override
    public boolean insert(Contract contract) {
        return contractRepository.insertContract(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
