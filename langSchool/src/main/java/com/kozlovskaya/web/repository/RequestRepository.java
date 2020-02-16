package com.kozlovskaya.web.repository;

import com.kozlovskaya.web.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findByAcceptIs(short accept);
    @Modifying
    @Query("delete from Request r where r.id = ?1")
    void delete(Integer entityId);
}