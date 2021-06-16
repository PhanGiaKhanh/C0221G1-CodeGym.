package com.model.repository;

import com.model.bean.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageRepository {
    private static Map<Integer, Language> languageMap = new HashMap<>();
    static{
        languageMap.put(1, new Language(1, "English"));
        languageMap.put(2, new Language(2, "Vietnamese"));
        languageMap.put(3, new Language(3, "Japanese"));
        languageMap.put(4, new Language(4, "Chinese"));
    }

    public List<Language> findAll(){
        return new ArrayList<>(languageMap.values());
    }
}
