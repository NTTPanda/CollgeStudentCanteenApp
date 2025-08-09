package com.example.CanteenCollegeApp.repository;


import com.example.CanteenCollegeApp.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack,Integer> {
    // Filter feedbacks on a specific date and time less than or equal
    List<FeedBack> findByDateAndTimeLessThanEqual(String date, String time);
}
