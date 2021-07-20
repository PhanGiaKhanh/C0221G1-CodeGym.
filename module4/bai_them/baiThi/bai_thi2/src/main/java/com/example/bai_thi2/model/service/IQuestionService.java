package com.example.bai_thi2.model.service;

import com.example.bai_thi2.model.entity.Question;
import com.example.bai_thi2.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGenericService<Question> {
    Page<Question> findAllTitleQuestionTypeId(String keyTitle, String keyQuestionTypeId, Pageable pageable);
}
