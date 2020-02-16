package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Message;
import com.kozlovskaya.web.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void saveOrUpdate(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void remove(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(Integer id) {
        return messageRepository.findOne(id);
    }

    @Override
    public List<Message> findAllIsNotAccepted() {
        return messageRepository.findByAcceptIs((short) 0);
    }
}
