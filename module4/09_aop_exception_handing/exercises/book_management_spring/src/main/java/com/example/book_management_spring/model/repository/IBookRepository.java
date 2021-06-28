package com.example.book_management_spring.model.repository;

import com.example.book_management_spring.model.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {
}
