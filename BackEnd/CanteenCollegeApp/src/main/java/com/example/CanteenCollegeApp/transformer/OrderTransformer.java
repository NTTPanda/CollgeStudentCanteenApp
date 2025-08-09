package com.example.CanteenCollegeApp.transformer;


import com.example.CanteenCollegeApp.dto.request.OrderRequest;
import com.example.CanteenCollegeApp.model.Order;
import com.example.CanteenCollegeApp.model.OrderItem;
import com.example.CanteenCollegeApp.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class OrderTransformer {

    public static Order convertToEntity(OrderRequest request, Student student) {
        Order order = new Order();
        order.setStudent(student);
        order.setTableNumber(request.getTableNumber());
        order.setDate(request.getDate());
        order.setTime(request.getTime());

        List<OrderItem> items = request.getItems().stream().map(itemReq -> {
            OrderItem item = new OrderItem();
            item.setFoodItem(itemReq.getFoodItem());
            item.setQuantity(itemReq.getQuantity());
            item.setPrice(itemReq.getPrice());
            item.setOrder(order); // set reverse mapping
            return item;
        }).collect(Collectors.toList());

        order.setOrderItems(items);

        // ✅ Calculate amount
        int totalAmount = items.stream()
                .mapToInt(i -> i.getQuantity() * (int)i.getPrice())
                .sum();
        order.setAmount(totalAmount); // Important

        return order;
    }
}
