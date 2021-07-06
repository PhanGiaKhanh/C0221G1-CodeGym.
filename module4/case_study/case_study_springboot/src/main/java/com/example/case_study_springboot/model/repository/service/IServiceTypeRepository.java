package com.example.case_study_springboot.model.repository.service;

import com.example.case_study_springboot.model.entity.service.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType, Integer> {
}
