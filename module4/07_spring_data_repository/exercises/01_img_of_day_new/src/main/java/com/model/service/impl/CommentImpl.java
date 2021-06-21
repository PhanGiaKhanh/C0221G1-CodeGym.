package com.model.service.impl;

import com.model.entity.Comment;
import com.model.repository.ICommentRepository;
import com.model.service.ICommentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
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
        Comment comment = findById(id).get();
        comment.setCountLike(comment.getCountLike()+1);
        save(comment);
    }


}
