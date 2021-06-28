package com.example.b01_complete_cart.model.repository;


import com.example.b01_complete_cart.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
    @Query(value = "select * from products where concat(product_name,' ', price) like :keySearch order by `date`", nativeQuery = true)
    Page<Product> searchNameAndPrice(@Param("keySearch") String keySearch, Pageable pageable);
}
