package com.example.case_study_springboot.model.repository.employee;

import com.example.case_study_springboot.model.entity.employee.Division;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends PagingAndSortingRepository<Division, Integer> {
}
