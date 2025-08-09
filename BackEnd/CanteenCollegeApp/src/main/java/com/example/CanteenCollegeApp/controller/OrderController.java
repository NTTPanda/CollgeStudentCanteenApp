package com.example.CanteenCollegeApp.controller;


import com.example.CanteenCollegeApp.dto.request.OrderRequest;
import com.example.CanteenCollegeApp.dto.response.OrderItemSummaryDTO;
import com.example.CanteenCollegeApp.model.Order;
import com.example.CanteenCollegeApp.repository.OrderItemRepository;
import com.example.CanteenCollegeApp.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
//@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    OrderItemRepository orderItemRepository;
    @PostMapping("/place")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            Order order = orderService.placeOrder(orderRequest);
            return "Order placed successfully. Order ID: " + order.getOrderId();
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }

//    // ✅ New endpoint to fetch order item summary
//    @GetMapping("/orderitems/byTable")
//    public List<OrderItemSummaryDTO> getOrderItemsByTableDateTime(
//            @RequestParam int tableNumber,
//            @RequestParam String date,
//            @RequestParam String time) {
//        return orderItemRepository.findOrderItemsByTableDateAndTime(tableNumber, date, time);
//    }

    // ✅ New endpoint to get orders from all tables by date and time
    @GetMapping("/orderitems/byDateTime")
    public List<OrderItemSummaryDTO> getOrderItemsByDateAndTime(
            @RequestParam String date,
            @RequestParam String time) {
        return orderItemRepository.findOrderItemsByDateAndTime(date, time);
    }

    @DeleteMapping("/byTable/{tableNumber}")
    public String deleteOrdersByTableNumber(@PathVariable int tableNumber) {
        orderService.deleteOrdersByTableNumber(tableNumber);
        return "All orders for table number " + tableNumber + " have been deleted.";
    }


}
