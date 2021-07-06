package com.example.case_study_springboot.model.service.impl.service;

import com.example.case_study_springboot.model.entity.service.RentType;
import com.example.case_study_springboot.model.repository.service.IRentTypeRepository;
import com.example.case_study_springboot.model.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void delete(Integer id) {

    }
}
