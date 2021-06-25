package com.example.b01_update_img_of_day.model.service.impl;



import com.example.b01_update_img_of_day.model.entity.Comment;
import com.example.b01_update_img_of_day.model.repository.ICommentRepository;
import com.example.b01_update_img_of_day.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentImpl implements ICommentService {
    @Autowired
    ICommentRepository commentRepository;
    @Override
    public Page<Comment> findAllByAuthorContaining(String author, Pageable pageable) {
        return commentRepository.findAllByAuthorContaining(author, pageable);
    }

    @Override
    public Page<Comment> findAllByOrderByStartDesc(Pageable pageable) {
        return commentRepository.findAllByOrderByStartDesc(pageable);
    }


    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) throws Exception {
        Optional<Comment> customerOptional = commentRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not found!");
        }
        return customerOptional;
    }

    @Override
    public void save(Comment comment) {

        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void like(Long id) {
         commentRepository.like(id);
    }


}
