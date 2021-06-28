package com.example.b01_complete_cart.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;


@Data
public class ProductDto {
    private Integer id;
    private String productId;
    private String productName;
    private MultipartFile image;
    private Integer oldPrice;
    private Integer price;
    private String amount;
    private String description;
    private String date;
}
