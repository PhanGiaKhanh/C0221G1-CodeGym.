package com.example.b02_book_management.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String manufacturer;
    private String img;
    private Integer stock;
    private String rentalDate;

    @OneToMany(mappedBy = "book")
    private List<RentalCode> rentalCodes;

    public Book() {
    }

    public Book(String name, String author, String manufacturer, String img) {
        this.name = name;
        this.author = author;
        this.manufacturer = manufacturer;
        this.img = img;
    }

    public Book(String name, String author, String manufacturer, String img, Integer stock) {
        this.name = name;
        this.author = author;
        this.manufacturer = manufacturer;
        this.img = img;
        this.stock = stock;
    }

    public Book(Integer id, String name, String author, String manufacturer, String img, Integer stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.manufacturer = manufacturer;
        this.img = img;
        this.stock = stock;
    }
}
