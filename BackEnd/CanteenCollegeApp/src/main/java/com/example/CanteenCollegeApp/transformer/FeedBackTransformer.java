package com.example.CanteenCollegeApp.transformer;


import com.example.CanteenCollegeApp.dto.request.FeedbackRequest;
import com.example.CanteenCollegeApp.dto.response.FeedbackResponse;
import com.example.CanteenCollegeApp.model.FeedBack;

public class FeedBackTransformer {

    public static FeedBack feedbackRequestToFeedBack(FeedbackRequest request) {
        FeedBack feedback = new FeedBack();
        feedback.setDate(request.getDate());
        feedback.setTime(request.getTime());
        feedback.setFeedback(request.getFeedback());
        return feedback;
    }

    public static FeedbackResponse feedbackToFeedbackResponse(FeedBack feedback) {
        FeedbackResponse response = new FeedbackResponse();
        response.setFeedback(feedback.getFeedback());
        return response;
    }
}
