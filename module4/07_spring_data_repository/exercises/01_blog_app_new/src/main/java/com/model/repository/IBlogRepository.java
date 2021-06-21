package com.model.repository;

import com.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog>  findAllByOrderByDateDesc(Pageable pageable);

}
