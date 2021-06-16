package com.model.impl;

import com.model.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements CalculatorService {
    @Override
    public Double calculator(Double num1, Double num2, String calculator) {
        double result= 0;
        switch (calculator){
            case "+": result = num1 + num2;break;
            case "-": result = num1 - num2;break;
            case "*": result = num1 * num2;break;
            case "/": result = num1 / num2;break;
        }
        return result;
    }
}
