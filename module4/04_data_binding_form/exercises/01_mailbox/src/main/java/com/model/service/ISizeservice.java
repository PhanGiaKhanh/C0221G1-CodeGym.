package com.model.service;

import com.model.bean.Size;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISizeservice {
    List<Size> findAll();
}
