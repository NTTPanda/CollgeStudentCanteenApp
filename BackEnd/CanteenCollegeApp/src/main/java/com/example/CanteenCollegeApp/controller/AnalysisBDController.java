package com.example.CanteenCollegeApp.controller;

import com.example.CanteenCollegeApp.dto.request.AnalysisBDRequest;
import com.example.CanteenCollegeApp.Service.AnalysisBDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analysis")
public class AnalysisBDController {

    @Autowired
    private AnalysisBDService analysisBDService;

    @PostMapping("/add")
    public String addAnalysis(@RequestBody AnalysisBDRequest request) {
        analysisBDService.saveAnalysis(request);
        return "Data saved successfully!";
    }
}
