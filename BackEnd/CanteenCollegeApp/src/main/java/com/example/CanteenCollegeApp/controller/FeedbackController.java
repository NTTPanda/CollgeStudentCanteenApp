package com.example.CanteenCollegeApp.controller;

import com.example.CanteenCollegeApp.dto.request.FeedbackRequest;
import com.example.CanteenCollegeApp.dto.response.FeedbackResponse;
import com.example.CanteenCollegeApp.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/add")
    public String addFeedBack(@RequestBody FeedbackRequest feedbackRequest){
        return feedbackService.addFeedBack(feedbackRequest);
    }
    @GetMapping("/filter")
    public List<FeedbackResponse> getFilteredFeedbacks(@RequestParam String date,
                                                       @RequestParam String time) {
        return feedbackService.getFilteredFeedbacks(date, time);
    }
}
