package com.example.b01_form_registration_springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;

@Data
public class UserDto implements Validator {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private int age;
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
//        !userDto.lastName.matches("^[a-zA-Z]+$")
        String firstName = userDto.firstName;
        String lastName = userDto.lastName;
        boolean checkFirstName = !firstName.matches("^[a-zA-Z]+$") && (firstName.length() < 1 || firstName.length() > 45);
        boolean checkLastName = !lastName.matches("^[a-zA-Z]+$") && (lastName.length() < 1 || lastName.length() > 45);
        if (checkFirstName) {
            errors.rejectValue("firstName", "firstName.invalidFormat");
        }
        if (checkLastName) {
            errors.rejectValue("lastName", "lastName.invalidFormat");
        }
        if (!userDto.phone.matches("^[0][0-9]{9,11}$")){
            errors.rejectValue("phone", "phone.format");
        }
        if (!(userDto.age >= 18)) {
            errors.rejectValue("age", "age.enoughAge");
        }
        if (!userDto.email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            errors.rejectValue("email", "email.emailFormat");
        }
    }
}
