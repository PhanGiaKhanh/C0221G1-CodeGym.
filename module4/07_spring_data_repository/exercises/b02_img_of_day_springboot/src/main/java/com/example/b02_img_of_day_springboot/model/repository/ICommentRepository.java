package com.example.b02_img_of_day_springboot.model.repository;


import com.example.b02_img_of_day_springboot.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findAllByAuthorContaining(String author, Pageable pageable);
    Page<Comment> findAllByOrderByStartDesc(Pageable pageable);

}
