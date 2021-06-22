package com.example.b01_create_blog.model.repository;

import com.example.b01_create_blog.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
