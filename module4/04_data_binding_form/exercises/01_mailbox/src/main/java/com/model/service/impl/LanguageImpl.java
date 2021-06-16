package com.model.service.impl;

import com.model.bean.Language;
import com.model.repository.LanguageRepository;
import com.model.service.ILanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageImpl implements ILanguageService {
    LanguageRepository languageRepository = new LanguageRepository();
    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }
}
