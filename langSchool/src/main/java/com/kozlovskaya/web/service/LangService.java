package com.kozlovskaya.web.service;


import com.kozlovskaya.web.entities.Lang;

import java.util.List;

public interface LangService {
    void saveOrUpdate(Lang lang);
    void remove(Lang lang);
    List<Lang> findAll();
    Lang findById(Integer id);
}
