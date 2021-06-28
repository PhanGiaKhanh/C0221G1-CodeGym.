package com.example.book_management_spring.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class BookCard {
    @Id
    private Long card_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookCard(Long card_id, Book book) {
        this.card_id = card_id;
        this.book = book;
    }

    public BookCard() {
    }
}
