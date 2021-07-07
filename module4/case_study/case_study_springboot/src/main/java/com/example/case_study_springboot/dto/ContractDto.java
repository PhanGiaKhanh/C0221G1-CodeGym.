package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.service.Service;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
public class ContractDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double contractDeposit;
    private Double contractTotalMoney;
    private List<ContractDetail> contractDetail;
    private Employee employee;
    private Customer customer;
    private Service service;
    private Boolean customerFlag;

}
