package com.example.shop_clothes.model.service.impl;

import com.example.shop_clothes.model.entity.Clothes;
import com.example.shop_clothes.model.repository.IClothesRepository;
import com.example.shop_clothes.model.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClothesService implements IClothesService {
    @Autowired
    IClothesRepository clothesRepository;

    @Override
    public Page<Clothes> findAllByCodeNameCost(String searchName, Pageable pageable) {
        return clothesRepository.findAllByCodeNameCost(searchName, pageable);
    }

    @Override
    public Iterable<Clothes> findAll() {
        return clothesRepository.findAll();
    }

    @Override
    public Optional<Clothes> findById(Integer id) {
        return clothesRepository.findById(id);
    }

    @Override
    public void save(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    @Override
    public void delete(Integer id) {
        clothesRepository.deleteById(id);
    }
}
