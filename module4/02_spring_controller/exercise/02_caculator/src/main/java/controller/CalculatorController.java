package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping
    public String home(){ return "/home";}

    @PostMapping
    public String calculator(@RequestParam String num1, String num2, String calculation, Model model){
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        double result= 0;
        switch (calculation){
            case "+": result = number1 + number2;break;
            case "-": result = number1 - number2;break;
            case "*": result = number1 * number2;break;
            case "/": result = number1 / number2;break;
        }
        model.addAttribute("result", result);
        return "/home";
    }
}
