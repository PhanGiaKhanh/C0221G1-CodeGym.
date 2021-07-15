package com.example.shop_clothes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController {
    @GetMapping({"","home"})
    public String goHome(){
        return "/home";
    }

    public static void main(String[] args) {
        System.out.println("hello");
        LocalDate currentDate = LocalDate.now();
        System.out.println(java.time.LocalDate.now());
        LocalDate birthDate = LocalDate.parse("2003-07-11");
        System.out.println(Period.between(birthDate, currentDate).getYears());
    }
}
