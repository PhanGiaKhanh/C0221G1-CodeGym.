package model.service;

import model.bean.contract.Contract;
import model.bean.employee.Employee;

import java.util.List;

public interface ContractService {
    boolean insert(Contract contract);
    List<Contract> findAll();
}
