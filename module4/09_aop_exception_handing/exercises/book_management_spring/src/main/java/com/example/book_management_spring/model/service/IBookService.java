package com.example.book_management_spring.model.service;

import com.example.book_management_spring.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IBookService extends  IGenericService<Book>{
}
