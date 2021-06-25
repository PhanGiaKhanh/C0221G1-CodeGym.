package com.example.b02_book_management.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class RentalCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idCard;
    @Column(name = "rental_code", unique = true)
    private String rentalCode;
    @Column(name = "rental_date")


    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;

    public RentalCode() {
    }

    public RentalCode(String idCard, String rentalCode, Book book) {
        this.idCard = idCard;
        this.rentalCode = rentalCode;
        this.book = book;
    }

    public RentalCode(Integer id, String idCard, String rentalCode, Book book) {
        this.id = id;
        this.idCard = idCard;
        this.rentalCode = rentalCode;
        this.book = book;
    }
}
