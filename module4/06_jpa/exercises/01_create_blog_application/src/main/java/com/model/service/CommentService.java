package com.model.service;

import com.model.bean.Comment;
import com.model.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;
    
    @Override
    public List findAll() {
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
}
