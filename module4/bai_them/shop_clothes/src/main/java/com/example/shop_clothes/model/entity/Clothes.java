package com.example.shop_clothes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String clothesCode;
    @Column(nullable = false)
    private String clothesName;
    @Column(nullable = false)
    private Double cost;
    private String date;
    private String description;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id",nullable = false)
    private ClothesType clothesType;
}
