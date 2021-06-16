package com.controller;


import com.model.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping
    public String home(){ return "/home";}

    @PostMapping
    public String calculator(@RequestParam Double num1, Double num2, String calculation, Model model){
        Double result = calculatorService.calculator(num1, num2, calculation);
        model.addAttribute("result", result);
        return "/home";
    }
}
