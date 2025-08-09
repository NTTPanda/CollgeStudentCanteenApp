package com.example.CanteenCollegeApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    private String date;
    private String time;
    private String feedback;

    // Default constructor
    public FeedBack() {}

    // Parameterized constructor
    public FeedBack(int feedbackId, String date, String time, String feedback) {
        this.feedbackId = feedbackId;
        this.date = date;
        this.time = time;
        this.feedback = feedback;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

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

    // Optional: toString
    @Override
    public String toString() {
        return "FeedBack{" +
                "feedbackId=" + feedbackId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
