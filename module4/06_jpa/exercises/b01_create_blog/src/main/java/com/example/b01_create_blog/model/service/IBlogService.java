package com.example.b01_create_blog.model.service;

import com.example.b01_create_blog.model.bean.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void delete(Long id);
 }
