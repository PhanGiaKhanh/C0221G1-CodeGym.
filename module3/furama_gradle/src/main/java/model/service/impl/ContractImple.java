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

    @Override
    public Contract finById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public boolean update(Contract contract) {
        return contractRepository.update(contract);
    }

    @Override
    public boolean delete(int id) {
        return contractRepository.delete(id);
    }
}
