package com.example.bai_thi2.model.service.impl;

import com.example.bai_thi2.model.entity.QuestionType;
import com.example.bai_thi2.model.repository.IQuestionTypeRepository;
import com.example.bai_thi2.model.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepository questionTypeRepository;
    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void delete(Integer id) {

    }
}
