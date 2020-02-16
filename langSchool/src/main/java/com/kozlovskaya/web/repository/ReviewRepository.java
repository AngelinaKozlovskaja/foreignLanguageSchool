package com.kozlovskaya.web.repository;

import com.kozlovskaya.web.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
