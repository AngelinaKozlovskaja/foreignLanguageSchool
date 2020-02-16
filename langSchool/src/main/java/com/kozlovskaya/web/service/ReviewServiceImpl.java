package com.kozlovskaya.web.service;

import com.kozlovskaya.web.entities.Review;
import com.kozlovskaya.web.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void saveOrUpdate(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void remove(Review review) {
        reviewRepository.delete(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Integer id) {
        return reviewRepository.findOne(id);
    }
}
