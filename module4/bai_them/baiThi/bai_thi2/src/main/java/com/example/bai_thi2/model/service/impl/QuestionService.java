package com.example.bai_thi2.model.service.impl;

import com.example.bai_thi2.model.entity.Question;
import com.example.bai_thi2.model.entity.customer.Customer;
import com.example.bai_thi2.model.repository.IQuestionRepository;
import com.example.bai_thi2.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAllTitleQuestionTypeId(String keyTitle, String keyQuestionTypeId, Pageable pageable) {
        return questionRepository.findAllTitleQuestionTypeId(keyTitle, keyQuestionTypeId, pageable);
    }
}
