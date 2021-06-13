package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("convert")
    public String converter(@RequestParam String money, String moneyType, String moneyType2, Model model){
        double result = Double.parseDouble(money) * Double.parseDouble(moneyType2) / Double.parseDouble(moneyType);
        model.addAttribute("result", result);
        return "home";
    }
}
