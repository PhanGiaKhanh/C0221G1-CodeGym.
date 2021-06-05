package model.service;

import model.bean.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    boolean insert(ContractDetail contractDetail);
    List<ContractDetail> findAll();
}
