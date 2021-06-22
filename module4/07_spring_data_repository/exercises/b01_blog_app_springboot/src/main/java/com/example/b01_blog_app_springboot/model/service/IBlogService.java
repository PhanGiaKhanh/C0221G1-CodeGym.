package com.example.b01_blog_app_springboot.model.service;

import com.example.b01_blog_app_springboot.model.entity.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog>  findAllByOrderByDateDesc(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
