package com.example.b03_uploadfile.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
public class ProductForm {
    private Integer id;

    private String name;

    private String description;

    private MultipartFile image;
}
