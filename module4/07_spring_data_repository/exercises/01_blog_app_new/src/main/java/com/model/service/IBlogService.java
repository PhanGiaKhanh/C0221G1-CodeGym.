package com.model.service;

import com.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog>  findAllByOrderByDateDesc(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
