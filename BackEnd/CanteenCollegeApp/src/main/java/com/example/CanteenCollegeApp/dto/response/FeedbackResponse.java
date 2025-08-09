package com.example.CanteenCollegeApp.dto.response;

public class FeedbackResponse {

    private String feedback;

    // Default constructor
    public FeedbackResponse() {}

    // Parameterized constructor
    public FeedbackResponse(String feedback) {

        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    // Optional: toString() method
    @Override
    public String toString() {
        return "FeedbackRequest{" +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
