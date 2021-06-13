package model.service.impl;

import model.repository.TranslateRepository;
import model.service.ITranslate;

public class TranslateImpl implements ITranslate {
    TranslateRepository translateRepository = new TranslateRepository();
    @Override
    public String transVn(String eng) {
        return translateRepository.transVn(eng);
    }

    @Override
    public String transEng(String vn) {
        return null;
    }
}
