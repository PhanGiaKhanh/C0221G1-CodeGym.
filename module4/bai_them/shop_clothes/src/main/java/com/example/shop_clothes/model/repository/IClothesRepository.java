package com.example.shop_clothes.model.repository;

import com.example.shop_clothes.model.entity.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClothesRepository extends PagingAndSortingRepository<Clothes, Integer> {
    @Query(value = "select  * from clothes where clothes_name like %?1% order by id desc ", nativeQuery = true)
    Page<Clothes> findAllByCodeNameCost(String searchName, Pageable pageable);
}
