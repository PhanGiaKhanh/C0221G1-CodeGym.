package com.example.bai_thi2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"", "/home"})
    public String goHome(){
        return "/home";
    }
}
