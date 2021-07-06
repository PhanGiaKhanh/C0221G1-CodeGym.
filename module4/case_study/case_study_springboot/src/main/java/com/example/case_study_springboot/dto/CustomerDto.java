package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.customer.CustomerType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
public class CustomerDto implements Validator {
    public final String PHONE_NUMBER="^(84|0[3|5|7|8|9])+([0-9]{8})$";
    public final String NAME="^[\\p{L} .'-]+$";
    public final String DATE="^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";

    private Integer id;
    private CustomerType customerType;
    private String customerCode;
    @NotBlank(message = "Please input name")
    private String customerName;
    @NotBlank(message = "Please input birthday")
    private String customerBirthday;
    @NotBlank(message = "Please input name")
    private String customerGender;
    @NotBlank(message = "Please input id card")
    private String customerIdCard;
    @NotBlank(message = "Please input phone")
    private String customerPhone;
    @Email
    private String customerEmail;
    private String customerAddress;
    private List<Contract> contractList;
    private Boolean customerFlag = true;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, CustomerType customerType, String customerCode, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.id = id;
        this.customerType = customerType;
        this.customerCode = customerCode;
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
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.customerCode.matches("^KH-[0-9]{4}$")){
            errors.rejectValue("customerCode", "customerCode.format");
        }
        if (!customerDto.customerPhone.matches(PHONE_NUMBER)){
            errors.rejectValue("customerPhone", "customerPhone.format");
        }
        if (!customerDto.customerBirthday.matches(DATE)){
            errors.rejectValue("customerBirthday", "customerBirthday.format");
        }
        if (!customerDto.customerIdCard.matches("^[0-9]{9}$|^[0-9]{12}$")){
            errors.rejectValue("customerIdCard", "customerIdCard.format");
        }
    }
}
