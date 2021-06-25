package com.example.b02_book_management.model.repository;

import com.example.b02_book_management.model.entity.RentalCode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalCodeRepository extends PagingAndSortingRepository<RentalCode, Integer> {
}
