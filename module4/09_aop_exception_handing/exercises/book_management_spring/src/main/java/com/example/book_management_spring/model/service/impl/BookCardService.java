package com.example.book_management_spring.model.service.impl;

import com.example.book_management_spring.model.entity.BookCard;
import com.example.book_management_spring.model.repository.IBookCardRepository;
import com.example.book_management_spring.model.service.IBookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookCardService implements IBookCardService {
    @Autowired
    IBookCardRepository bookCardRepository;

    @Override
    public Iterable<BookCard> findAll() {
        return bookCardRepository.findAll();
    }

    @Override
    public Optional<BookCard> findById(Long id) {
        return bookCardRepository.findById(id);
    }

    @Override
    public void save(BookCard bookCard) {
        bookCardRepository.save(bookCard);
    }

    @Override
    public void remove(Long id) {
        bookCardRepository.deleteById(id);
    }


}
