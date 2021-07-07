package com.example.case_study_springboot.model.service.impl.contract;

import com.example.case_study_springboot.model.entity.contract.AttachService;
import com.example.case_study_springboot.model.repository.contract.IAttachServiceRepository;
import com.example.case_study_springboot.model.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Integer id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void delete(Integer id) {
        attachServiceRepository.deleteById(id);
    }
}
