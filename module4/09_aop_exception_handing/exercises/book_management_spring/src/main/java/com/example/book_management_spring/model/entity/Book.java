package com.example.book_management_spring.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_code")
    private String bookCode;
    @Column(name = "book_name")
    private String bookName;
    private Integer amount;
    private Integer view=0;

    @OneToMany(mappedBy = "book")
    private List<BookCard> cardList;


    public void increaseView(){
        view++;
    }
    public void increaseAmount(){
        amount++;
    }
    public void reducedAmount(){
        amount--;
    }
}
