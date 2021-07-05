package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.customer.CustomerType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.List;
@Getter
@Setter
public class CustomerDto implements Validator {
    private Integer id;
    private CustomerType customerType;
    private String customerName;
    private String customerBirthday;
    private String customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private List<Contract> contractList;
    private Boolean customerFlag = true;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, CustomerType customerType, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.id = id;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
