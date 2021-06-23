package com.example.b01_blog_app_springboot.model.repository;

import com.example.b01_blog_app_springboot.model.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {

}
