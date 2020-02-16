package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Lang;
import com.kozlovskaya.web.repository.LangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangServiceImpl implements LangService {

    @Autowired
    private LangRepository langRepository;

    @Override
    public void saveOrUpdate(Lang lang) {
        langRepository.save(lang);
    }

    @Override
    public void remove(Lang lang) {
        langRepository.delete(lang);
    }

    @Override
    public List<Lang> findAll() {
        return langRepository.findAll();
    }

    @Override
    public Lang findById(Integer id) {
        return langRepository.findOne(id);
    }
}
