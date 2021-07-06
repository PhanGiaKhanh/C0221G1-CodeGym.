package com.example.case_study_springboot.model.repository.service;

import com.example.case_study_springboot.model.entity.service.RentType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRentTypeRepository extends PagingAndSortingRepository<RentType, Integer> {
}
