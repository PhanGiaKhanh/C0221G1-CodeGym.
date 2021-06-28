package com.example.b01_complete_cart.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity(name = "products")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productId;
    @Column(name = "product_name")
    private String productName;
    private String image;
    @Column(name = "old_price")
    private Integer oldPrice;
    @Column(name = "price")
    private Integer price;
    private String amount;
    private String description;
    @Column(columnDefinition = "DATE")
    private String date;

    public Product(Integer id, String productId, String productName, String img, Integer oldPrice, Integer price, String amount, String description, String date) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.image = img;
        this.oldPrice = oldPrice;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Product() {
    }
}
