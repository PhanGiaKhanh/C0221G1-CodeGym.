package com.model.service.impl;

import com.model.bean.Comment;
import com.model.repository.ICommentRepository;
import com.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;

    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return iCommentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        iCommentRepository.remove(id);
    }

    @Override
    public void like(Long id) {
        iCommentRepository.like(id);
    }
}
