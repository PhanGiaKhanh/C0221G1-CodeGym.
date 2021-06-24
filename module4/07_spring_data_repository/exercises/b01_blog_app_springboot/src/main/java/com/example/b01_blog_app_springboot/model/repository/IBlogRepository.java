package com.example.b01_blog_app_springboot.model.repository;


import com.example.b01_blog_app_springboot.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);

}
