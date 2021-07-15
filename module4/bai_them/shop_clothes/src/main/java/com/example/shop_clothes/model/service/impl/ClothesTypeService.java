package com.example.shop_clothes.model.service.impl;

import com.example.shop_clothes.model.entity.ClothesType;
import com.example.shop_clothes.model.service.IClothesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClothesTypeService implements IClothesTypeService {
    @Autowired
    IClothesTypeService clothesTypeService;

    @Override
    public Iterable<ClothesType> findAll() {
        return clothesTypeService.findAll();
    }

    @Override
    public Optional<ClothesType> findById(Integer id) {
        return clothesTypeService.findById(id);
    }

    @Override
    public void save(ClothesType clothesType) {
        clothesTypeService.save(clothesType);
    }

    @Override
    public void delete(Integer id) {
        clothesTypeService.delete(id);
    }
}
