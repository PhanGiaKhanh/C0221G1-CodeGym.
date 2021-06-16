package com.model.service;

import com.model.bean.Language;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ILanguageService {
    List<Language> findAll();
}
