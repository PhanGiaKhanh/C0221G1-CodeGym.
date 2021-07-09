package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.AttachService;
import com.example.case_study_springboot.model.entity.contract.Contract;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Min;

@Getter
@Setter
public class ContractDetailDto implements Validator {
    private Integer id;
    private AttachService attachService;
    private Contract contract;
    @Min(0)
    private Integer quantity;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
