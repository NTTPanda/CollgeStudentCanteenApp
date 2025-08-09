package com.example.CanteenCollegeApp.controller;



import com.example.CanteenCollegeApp.dto.response.OrderItemSummaryDTO;
import com.example.CanteenCollegeApp.repository.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/byDateTime")
    public List<OrderItemSummaryDTO> getOrderItemsByDateTime(
            @RequestParam String date,
            @RequestParam String time) {
        return orderItemRepository.findOrderItemsByDateAndTime(date, time);
    }
}
