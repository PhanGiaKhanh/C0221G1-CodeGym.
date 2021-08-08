package com.example.productbackend.model.entity.security.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SignupRequest {
    private Integer bookId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String phone;
    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "wrong format, should be abc@abc.com ")
    private String email;
    @NotBlank
    @Length(min = 8, max = 32)
    private String password;
}
