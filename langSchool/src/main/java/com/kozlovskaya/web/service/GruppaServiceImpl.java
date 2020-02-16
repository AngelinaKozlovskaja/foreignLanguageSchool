package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Gruppa;
import com.kozlovskaya.web.repository.GruppaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GruppaServiceImpl implements GruppaService {

    @Autowired
    private GruppaRepository gruppaRepository;

    @Override
    public void saveOrUpdate(Gruppa gruppa) {
        gruppaRepository.save(gruppa);
    }

    @Override
    public void remove(Gruppa gruppa) {
        gruppaRepository.delete(gruppa);
    }

    @Override
    public List<Gruppa> findAll() {
        return gruppaRepository.findAll();
    }

    @Override
    public Gruppa findById(Integer id) {
        return gruppaRepository.findOne(id);
    }
}