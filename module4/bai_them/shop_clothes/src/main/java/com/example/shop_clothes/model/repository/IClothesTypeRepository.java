package com.example.shop_clothes.model.repository;

import com.example.shop_clothes.model.entity.ClothesType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClothesTypeRepository extends PagingAndSortingRepository<ClothesType, Integer> {
}
