package com.example.book_management_spring.dto;

import lombok.Data;

@Data
public class BookDto {
    private Integer id;
    private String bookCode;
    private String bookName;
    private Integer amount;
    private Integer view;
}
