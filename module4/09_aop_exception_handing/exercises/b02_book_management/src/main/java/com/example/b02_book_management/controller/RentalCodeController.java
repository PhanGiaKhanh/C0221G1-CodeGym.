package com.example.b02_book_management.controller;

import com.example.b02_book_management.model.service.IBookService;
import com.example.b02_book_management.model.service.IRentalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/rentalCodes")
public class RentalCodeController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IRentalCodeService rentalCodeImpl;

    @GetMapping(value = "")
    public String showListRentalCode(Model model){
        model.addAttribute("rentalCodes", rentalCodeImpl.findAll());
        return "rental_code/list";
    }
}