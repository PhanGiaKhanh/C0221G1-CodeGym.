package com.model.service.impl;

import com.model.bean.Size;
import com.model.repository.SizeRepository;
import com.model.service.ISizeservice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeImpl implements ISizeservice {
    SizeRepository sizeRepository = new SizeRepository();
    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }


}
