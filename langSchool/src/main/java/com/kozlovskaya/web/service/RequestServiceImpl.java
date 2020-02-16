package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Request;
import com.kozlovskaya.web.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Override
    @Transactional
    public void saveOrUpdate(Request request) {
        requestRepository.save(request);
    }

    @Override
    @Transactional
    public void remove(Request request) {
        requestRepository.delete(request.getId());
    }

    @Override
    @Transactional
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    @Transactional
    public Request findById(Integer id) {
        return requestRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<Request> findByAcceptFalse() {
        return requestRepository.findByAcceptIs((short) 0);
    }
}
