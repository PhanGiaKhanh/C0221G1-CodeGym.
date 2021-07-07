package com.example.case_study_springboot.model.repository.contract;

import com.example.case_study_springboot.model.entity.contract.AttachService;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAttachServiceRepository extends PagingAndSortingRepository<AttachService, Integer> {
}
