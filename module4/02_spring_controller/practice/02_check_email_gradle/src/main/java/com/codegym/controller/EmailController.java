package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("")
    public String home(){
        return "home";
    }

    @PostMapping("validate")
    public String checkEmail(@RequestParam("email") String email, Model model, ModelMap modelMap){
        boolean checkEmail = email.matches(REGEX_EMAIL);
        if (checkEmail) {
            model.addAttribute( "message", "Email is valid");
            modelMap.addAttribute("email", email);
        }else {
            model.addAttribute( "message", "Email is invalid");
            modelMap.addAttribute("email", email);
        }
        return "home";
    }
}
