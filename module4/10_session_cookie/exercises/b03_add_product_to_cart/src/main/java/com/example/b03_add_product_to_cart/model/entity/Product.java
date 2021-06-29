package com.example.b03_add_product_to_cart.model.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private double price;
    private String description;

}
