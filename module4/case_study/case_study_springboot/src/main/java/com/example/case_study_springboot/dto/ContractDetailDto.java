package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.AttachService;
import com.example.case_study_springboot.model.entity.contract.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class ContractDetailDto {
    private Integer id;
    private AttachService attachService;
    private Contract contract;
    private Integer quantity;

}
