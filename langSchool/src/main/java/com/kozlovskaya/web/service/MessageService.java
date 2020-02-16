package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Message;

import java.util.List;

public interface MessageService {
    void saveOrUpdate(Message message);
    void remove(Message message);
    List<Message> findAll();
    Message findById(Integer id);
    List<Message> findAllIsNotAccepted();
}
