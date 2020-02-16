package com.kozlovskaya.web.repository;

import com.kozlovskaya.web.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByAcceptIs(short accept);
}
