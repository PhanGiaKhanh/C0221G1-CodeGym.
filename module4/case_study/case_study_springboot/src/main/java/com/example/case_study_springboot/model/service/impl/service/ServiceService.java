package com.example.case_study_springboot.model.service.impl.service;

import com.example.case_study_springboot.model.entity.service.Service;
import com.example.case_study_springboot.model.repository.service.IServiceRepository;
import com.example.case_study_springboot.model.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;


    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }
}
