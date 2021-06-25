package com.example.b02_book_management.model.service.impl;

import com.example.b02_book_management.model.entity.Book;
import com.example.b02_book_management.model.repository.IBookRepository;
import com.example.b02_book_management.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
