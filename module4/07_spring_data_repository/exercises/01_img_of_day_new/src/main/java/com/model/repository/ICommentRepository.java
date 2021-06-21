package com.model.repository;

import com.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long>, JpaRepository<Comment,Long> {
    Page<Comment> findAllByAuthorContaining(String author, Pageable  pageable);
    Page<Comment> findAllByOrderByStartDesc(Pageable pageable);

}
