package com.example.CanteenCollegeApp.repository;


import com.example.CanteenCollegeApp.dto.response.OrderItemSummaryDTO;
import com.example.CanteenCollegeApp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query("SELECT new com.example.CanteenCollegeApp.dto.response.OrderItemSummaryDTO(" +
            "oi.order.tableNumber, oi.foodItem, oi.price, oi.quantity) " +
            "FROM OrderItem oi " +
            "WHERE oi.order.date = :date AND oi.order.time <= :time")
    List<OrderItemSummaryDTO> findOrderItemsByDateAndTime(
            @Param("date") String date,
            @Param("time") String time);
}
