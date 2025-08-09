package com.example.CanteenCollegeApp.dto.request;

public class FeedbackRequest {
    private String date;
    private String time;
    private String feedback;

    // Default constructor
    public FeedbackRequest() {}

    // Parameterized constructor
    public FeedbackRequest(String date, String time, String feedback) {
        this.date = date;
        this.time = time;
        this.feedback = feedback;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
