package com.example.case_study_springboot.model.repository.service;

import com.example.case_study_springboot.model.entity.service.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IServiceRepository extends PagingAndSortingRepository<Service, Integer> {
}
