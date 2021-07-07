package com.example.case_study_springboot.model.repository.employee;

import com.example.case_study_springboot.model.entity.employee.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position, Integer> {
}
