package com.example.b03_product_springboot.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ProductDto implements Validator {
    private Integer id;
    @NotBlank(message = "Has not space around")
    @Size(min = 1, max = 45)
    private String name;
    @Min(100)
    private String price;
    private String description;
    private String manufacturer;
    private LocalDate date = LocalDate.now();


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (!productDto.name.matches("[a-zA-z]*")){
            errors.rejectValue("name", "name.nameFormat");
        }
    }
}
