package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.service.Service;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ContractDto implements Validator {
    private Integer id;
//    @Pattern(regexp = "^[0-9]{2}[/]([0][1-9])|([1][0-2])[/][0-9]{4}$", message = "This is not day")
//    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "This is not day")
    private String startDate;
//   
    private String endDate;
//    @Min(@Pattern(regexp = "^[0-9]{2}/([0][1-9])|([1][0-2])/[0-9]{4}$", message = "This is not day"))
    private Double contractDeposit;
    @Min(0)
    private Double contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;
    private Boolean contractFlag = true;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        Date sDate= new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.startDate);
        Date eDate= new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.endDate);
        if (eDate.getTime()<sDate.getTime()){
            errors.rejectValue("endDate", "endDate.valid", "End date must be more start date");
        }
    }
}
