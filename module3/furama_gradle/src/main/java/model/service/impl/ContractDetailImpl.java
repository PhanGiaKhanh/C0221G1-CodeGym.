package model.service.impl;

import model.bean.contract.ContractDetail;
import model.repository.ContractDetailRepository;
import model.service.ContractDetailService;

import java.util.List;

public class ContractDetailImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public boolean insert(ContractDetail contractDetail) {
        return contractDetailRepository.insert(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
