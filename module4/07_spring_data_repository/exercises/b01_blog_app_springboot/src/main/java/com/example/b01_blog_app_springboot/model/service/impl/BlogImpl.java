package com.example.b01_blog_app_springboot.model.service.impl;

import com.example.b01_blog_app_springboot.model.entity.Blog;
import com.example.b01_blog_app_springboot.model.repository.IBlogRepository;
import com.example.b01_blog_app_springboot.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);

    }
    @Override
    public Page<Blog> findAllByOrderByDateDesc(Pageable pageable){
        return blogRepository.findAllByOrderByDateDesc(pageable);
    }
    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title, pageable);
    }


    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
