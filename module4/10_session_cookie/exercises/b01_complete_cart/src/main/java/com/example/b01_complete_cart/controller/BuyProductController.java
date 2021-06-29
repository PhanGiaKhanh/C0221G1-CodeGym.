package com.example.b01_complete_cart.controller;


import com.example.b01_complete_cart.model.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/buy")
public class BuyProductController {

    @GetMapping("/")
    public String buyProductList(@SessionAttribute List<Product> productBuyList, Model model){
        model.addAttribute("productBuyList", productBuyList);
        return "/product_buy";
    }
}
