package com.example.shop_clothes.dto;

import com.example.shop_clothes.model.entity.ClothesType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClothesDto {
    private Integer id;
    @NotBlank
    private String clothesCode;
    @NotBlank
    private String clothesName;
    @NotNull
    private Double cost;
    private String date;
    private String description;
    private ClothesType clothesType;
}
