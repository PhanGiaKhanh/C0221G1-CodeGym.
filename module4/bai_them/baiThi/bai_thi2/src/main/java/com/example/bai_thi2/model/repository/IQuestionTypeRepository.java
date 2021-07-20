package com.example.bai_thi2.model.repository;

import com.example.bai_thi2.model.entity.QuestionType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IQuestionTypeRepository extends PagingAndSortingRepository<QuestionType, Integer> {
}
