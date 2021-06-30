package com.example.b01_blog_app_springboot.model.service;

import com.example.b01_blog_app_springboot.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAll(Pageable pageable);
    void save(Category category);
    List<Category> findAllList();
}