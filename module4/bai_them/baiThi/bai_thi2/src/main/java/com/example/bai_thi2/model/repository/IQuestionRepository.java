package com.example.bai_thi2.model.repository;

import com.example.bai_thi2.model.entity.Question;
import com.example.bai_thi2.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IQuestionRepository extends PagingAndSortingRepository<Question, Integer> {
        @Query(value = "select * from question " +
                "where  (title like %?1%) " +
                "and (question_type_id like %?2%) " +
                "and (flag = 1)" +
                "order by id desc ", nativeQuery = true)
    Page<Question> findAllTitleQuestionTypeId(String keyTitle, String keyQuestionTypeId, Pageable pageable);

}
