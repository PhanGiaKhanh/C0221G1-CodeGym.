package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.employee.Division;
import com.example.case_study_springboot.model.entity.employee.EducationDegree;
import com.example.case_study_springboot.model.entity.employee.Position;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class EmployeeDto implements Validator {
    private Integer id;
    @NotBlank
    private String employeeName;
    @NotBlank
    private String birthday;
    @NotBlank
    private String salary;
    @NotBlank
    private String phone;
    @Email
    private String email;
    private String address;
    private Division division;
    private EducationDegree educationDegree;
    private Position position;
    private List<Contract> contractList;
    private Boolean flag = true;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (!employeeDto.phone.matches("^(090|091|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$")){
            errors.rejectValue("phone", "phone.format");
        }
    }
}
