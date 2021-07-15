package com.example.shop_clothes.model.service;

import com.example.shop_clothes.model.entity.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClothesService extends IGenericService<Clothes> {
    Page<Clothes> findAllByCodeNameCost(String searchName, Pageable pageable);
}
