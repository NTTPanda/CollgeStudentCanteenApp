package com.example.CanteenCollegeApp.repository;



import com.example.CanteenCollegeApp.model.Order;
import com.example.CanteenCollegeApp.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {


    List<Order> findByTableNumber(int tableNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Order o WHERE o.tableNumber = :tableNumber")
    void deleteByTableNumber(int tableNumber);




}
