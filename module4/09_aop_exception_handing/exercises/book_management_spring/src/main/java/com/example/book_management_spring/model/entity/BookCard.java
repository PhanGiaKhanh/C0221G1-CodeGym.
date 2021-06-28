package com.example.book_management_spring.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class BookCard {
    @Id
    private Long card_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookCard(Long code,  Book book) {
    }

    public BookCard() {

    }
}
