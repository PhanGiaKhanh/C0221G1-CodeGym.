package com.example.case_study_springboot.model.service.impl.service;

import com.example.case_study_springboot.model.entity.service.ServiceType;
import com.example.case_study_springboot.model.repository.service.IServiceTypeRepository;
import com.example.case_study_springboot.model.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public void delete(Integer id) {

    }
}
