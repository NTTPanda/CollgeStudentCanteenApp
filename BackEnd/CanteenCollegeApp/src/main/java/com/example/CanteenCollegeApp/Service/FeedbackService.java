package com.example.CanteenCollegeApp.Service;

import com.example.CanteenCollegeApp.dto.request.FeedbackRequest;
import com.example.CanteenCollegeApp.dto.response.FeedbackResponse;
import com.example.CanteenCollegeApp.model.FeedBack;
import com.example.CanteenCollegeApp.repository.FeedbackRepository;
import com.example.CanteenCollegeApp.transformer.FeedBackTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public String addFeedBack(FeedbackRequest feedbackRequest) {
        FeedBack feedBack = FeedBackTransformer.feedbackRequestToFeedBack(feedbackRequest);
        feedbackRepository.save(feedBack);
        return "Feedback submitted successfully!";
    }


    public List<FeedbackResponse> getFilteredFeedbacks(String date, String time) {
        return feedbackRepository.findByDateAndTimeLessThanEqual(date, time)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private FeedbackResponse convertToResponse(FeedBack feedback) {
        FeedbackResponse response = new FeedbackResponse();
        response.setFeedback(feedback.getFeedback());
        return response;
    }


}
