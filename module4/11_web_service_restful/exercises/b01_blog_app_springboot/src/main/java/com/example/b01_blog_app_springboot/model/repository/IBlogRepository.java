package com.example.b01_blog_app_springboot.model.repository;


import com.example.b01_blog_app_springboot.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {

        @Transactional
    @Modifying
    @Query(value = "select  * from blogs where category_id = :categoryId", nativeQuery = true)
        List<Blog> findAllBlogByIdCategory(@Param("categoryId") Long categoryId);

//    @Transactional
//    @Modifying
//    @Query(value = "select  * from blogs where category_id = 1", nativeQuery = true)
//    Page<Blog> findAllBlogByIdCategory( Long categoryId);



    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);



}
