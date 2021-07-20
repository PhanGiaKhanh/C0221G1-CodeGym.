package com.example.bai_thi2.dto;

import com.example.bai_thi2.model.entity.QuestionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class QuestionDto implements Validator {
    private Integer id;
    private String title;
    private String question;
    private String answer;
    private QuestionType questionType;
    private String dateCreate = LocalDate.now().toString();
    private String status = "Chờ phản hồi";
    private Boolean flag = true;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
