package com.example.b03_product_springboot.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Product {
//    id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String manufacturer;
    @Column(columnDefinition = "date")
    private LocalDate date= LocalDate.now();

    public Product(Integer id, String name, Double price, String description, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;

    }

    public Product(String name, Double price, String description, String manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.date =date;
    }

    public Product() {
    }

}
