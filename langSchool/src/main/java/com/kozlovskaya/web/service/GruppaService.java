package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Gruppa;

import java.util.List;

public interface GruppaService {
    void saveOrUpdate(Gruppa gruppa);
    void remove(Gruppa gruppa);
    List<Gruppa> findAll();
    Gruppa findById(Integer id);
}
