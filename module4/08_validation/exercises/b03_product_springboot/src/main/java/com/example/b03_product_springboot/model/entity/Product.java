package com.example.b03_product_springboot.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;
    private String description;
    private String manufacturer;
    @Column(columnDefinition = "date")
    private LocalDate date= LocalDate.now();

}
