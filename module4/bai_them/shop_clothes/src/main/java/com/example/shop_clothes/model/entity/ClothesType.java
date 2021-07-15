package com.example.shop_clothes.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ClothesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clothesTypeName;
    @OneToMany(mappedBy = "clothesType")
    private  List<Clothes> clothesList;
}
