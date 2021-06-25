package com.example.b02_book_management.controller;

import com.example.b02_book_management.model.service.IBookService;
import com.example.b02_book_management.model.service.IRentalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IRentalCodeService rentalCodeImpl;


}
