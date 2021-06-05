package model.service.impl;

import model.bean.contract.AttachService;
import model.repository.AttachServiceRepository;
import model.service.AttachServiceService;

import java.util.List;

public class AttachServiceImpl implements AttachServiceService {
    AttachServiceRepository attachServiceRepository = new AttachServiceRepository();

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
