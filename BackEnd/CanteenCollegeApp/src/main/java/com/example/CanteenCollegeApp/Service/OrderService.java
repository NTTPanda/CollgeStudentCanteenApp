package com.example.CanteenCollegeApp.Service;


import com.example.CanteenCollegeApp.dto.request.OrderRequest;
import com.example.CanteenCollegeApp.model.Order;
import com.example.CanteenCollegeApp.model.Student;
import com.example.CanteenCollegeApp.repository.StudentRepository;
import com.example.CanteenCollegeApp.repository.OrderRepository;
import com.example.CanteenCollegeApp.transformer.OrderTransformer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(OrderRequest request) {
        Student student = studentRepository.findByUsn(request.getStudentUsn())
                .orElseThrow(() -> new RuntimeException("Student with USN " + request.getStudentUsn() + " not found"));

        Order order = OrderTransformer.convertToEntity(request, student);
        return orderRepository.save(order);
    }

//    public List<Order> getOrdersByTableNumberDateTime(int tableNumber, String date, String time) {
//        return orderRepository.findByTableNumberAndDateAndTimeLessThanEqual(tableNumber, date, time);
//    }

    @Transactional
    public void deleteOrdersByTableNumber(int tableNumber) {
        List<Order> orders = orderRepository.findByTableNumber(tableNumber);
        orderRepository.deleteAll(orders); // this will trigger cascade delete
    }
}
