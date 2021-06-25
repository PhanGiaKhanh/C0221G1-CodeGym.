package com.example.b02_book_management.model.service.impl;

import com.example.b02_book_management.model.entity.RentalCode;
import com.example.b02_book_management.model.repository.IRentalCodeRepository;
import com.example.b02_book_management.model.service.IRentalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RentalCodeImpl implements IRentalCodeService {
    @Autowired
    IRentalCodeRepository rentalCodeRepository;


    @Override
    public Iterable<RentalCode> findAll() {
        return rentalCodeRepository.findAll();
    }

    @Override
    public Optional<RentalCode> findById(Integer id) {
        return rentalCodeRepository.findById(id);
    }

    @Override
    public void save(RentalCode rentalCode) {
        rentalCodeRepository.save(rentalCode);
    }

    @Override
    public void deleteById(Integer id) {
        rentalCodeRepository.deleteById(id);
    }
}
