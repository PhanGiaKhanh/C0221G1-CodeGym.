package com.example.b01_blog_app_springboot.model.service.impl;


import com.example.b01_blog_app_springboot.model.entity.Category;
import com.example.b01_blog_app_springboot.model.repository.ICategoryRepository;
import com.example.b01_blog_app_springboot.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllList() {
        return (List<Category>) categoryRepository.findAll();
    }
}
