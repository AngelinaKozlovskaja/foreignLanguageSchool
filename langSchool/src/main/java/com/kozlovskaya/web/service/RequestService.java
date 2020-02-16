package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Request;

import java.util.List;

public interface RequestService {
    void saveOrUpdate(Request request);
    void remove(Request request);
    List<Request> findAll();
    Request findById(Integer id);
    List<Request> findByAcceptFalse();
}
