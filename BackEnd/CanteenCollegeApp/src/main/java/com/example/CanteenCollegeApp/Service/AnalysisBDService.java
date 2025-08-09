package com.example.CanteenCollegeApp.Service;

import com.example.CanteenCollegeApp.dto.request.AnalysisBDRequest;
import com.example.CanteenCollegeApp.model.AnalysisBD;
import com.example.CanteenCollegeApp.repository.AnalysisBDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisBDService {

    @Autowired
    private AnalysisBDRepository analysisBDRepository;

    public AnalysisBD saveAnalysis(AnalysisBDRequest request) {
        AnalysisBD analysis = new AnalysisBD();

        analysis.setDate(request.getDate());
        analysis.setTime(request.getTime());
        analysis.setFoodItemName(request.getFoodItemName());
        analysis.setPrice(request.getPrice());
        analysis.setQuantity(request.getQuantity());
        analysis.setTotalAmount(request.getTotalAmount());

        return analysisBDRepository.save(analysis);
    }
}
