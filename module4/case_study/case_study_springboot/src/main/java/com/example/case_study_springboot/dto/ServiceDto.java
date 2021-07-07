package com.example.case_study_springboot.dto;

import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.service.RentType;
import com.example.case_study_springboot.model.entity.service.ServiceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
@Getter
@Setter
public class ServiceDto implements Validator {
    private Integer id;

    private String serviceName;
    @Pattern(regexp = "^DV-[0-9]{4}")
    private String serviceCode;
    @Min(10)
    private Integer serviceArea;
    @Min(1)
    private Double serviceCost;
    @Min(1)
    private Integer serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(10)
    private Double poolArea;
    @Min(1)
    private Integer numberOfFloors;
    private List<Contract> contractList;
    private Boolean serviceFlag = true;

    public ServiceDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (serviceDto.serviceName == ""){
            errors.rejectValue("serviceName", "serviceName.notNull");
        }
        if (serviceDto.serviceCost == null){
            errors.rejectValue("serviceCost", "serviceCost.notNull");
        }
    }
}
