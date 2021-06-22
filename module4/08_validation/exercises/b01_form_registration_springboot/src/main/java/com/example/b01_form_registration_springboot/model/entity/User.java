package com.example.b01_form_registration_springboot.model.entity;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Component
@Entity(name = "users")
public class User {
    //    Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự
//    Phonenumber đúng quy tắc của sđt
//    Age >=18
//    Email đúng quy tắc của email
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name is mandatory")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^[0][0-9]{9,11}$", message = "This not phone number")
    private String phone;
    @Min(18)
    private int age;
//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    public User() {
    }

    public User(@NotBlank(message = "First name is mandatory") @Size(min = 5, max = 45) String firstName, @NotBlank(message = "Last name is mandatory") @Size(min = 5, max = 45) String lastName, @Pattern(regexp = "^[0][0-9]{9,11}$") String phone, @Min(18) int age, @NotBlank(message = "Email is mandatory") @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public User(Long id, @NotBlank(message = "First name is mandatory") @Size(min = 5, max = 45) String firstName, @NotBlank(message = "Last name is mandatory") @Size(min = 5, max = 45) String lastName,  @Pattern(regexp = "^[0][0-9]{9,11}$") String phone, @Min(18) int age, @NotBlank(message = "Email is mandatory") @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
