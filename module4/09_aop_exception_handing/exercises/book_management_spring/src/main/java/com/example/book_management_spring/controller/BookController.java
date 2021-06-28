package com.example.book_management_spring.controller;

import com.example.book_management_spring.exception.BookException;
import com.example.book_management_spring.exception.NotFoundCodeException;
import com.example.book_management_spring.model.entity.Book;
import com.example.book_management_spring.model.entity.BookCard;
import com.example.book_management_spring.model.service.IBookCardService;
import com.example.book_management_spring.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller

public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBookCardService bookCardService;

    @GetMapping(value = {"", "books"})
    public String goHome(Model model){
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "/list";
    }

    @GetMapping(value = "create-book")
    public String showCreateBook(Model model){
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping(value = "create-book")
    public String saveBook(@ModelAttribute Book book, Model model){
        bookService.save(book);
        model.addAttribute("book", book);
        model.addAttribute("msg", "Succession");
        return "/create";
    }
    @GetMapping(value = "books/{id}/borrow-book")
    public String borrowBook(@PathVariable Integer id) throws Exception {
        Book book = bookService.findById(id).orElse(null);
        if (book.getAmount()== 0){
            throw new BookException();
        }
        book.reducedAmount();
        bookService.save(book);
        Long code = Math.round(Math.random()*89999 + 10000);
        BookCard bookCard = new BookCard(code, book);
        bookCardService.save(bookCard);
        return "redirect:/books";
    }

    @GetMapping(value = "pay-book")
    public String payBook(@RequestParam Integer code) throws Exception {
        BookCard bookCard = bookCardService.findById(code).orElse(null);
        if (bookCard == null){
            throw new NotFoundCodeException();
        }
        Integer id = bookCard.getBook().getId();
        Book book = bookService.findById(id).orElse(null);
        book.increaseAmount();
        bookService.save(book);
        bookCardService.remove(code);
        return "redirect:/books";
    }

    @ExceptionHandler(BookException.class)
    public String findNotFoundBook(){
        return "/ErrorFindNotFound";
    }
    @ExceptionHandler(NotFoundCodeException.class)
    public String findNotFoundCode(){
        return "/ErrorFindNotCode";
    }
}
