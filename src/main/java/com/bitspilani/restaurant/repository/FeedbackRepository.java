package com.bitspilani.restaurant.repository;

import com.bitspilani.restaurant.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
