package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Review;

import java.util.List;

public interface ReviewService {
    void saveOrUpdate(Review review);
    void remove(Review review);
    List<Review> findAll();
    Review findById(Integer id);
}
