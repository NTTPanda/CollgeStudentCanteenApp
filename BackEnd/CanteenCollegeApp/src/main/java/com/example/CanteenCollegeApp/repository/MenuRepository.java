package com.example.CanteenCollegeApp.repository;

import com.example.CanteenCollegeApp.model.MenuTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuTable, Integer> {
    // Custom methods (if any)
    MenuTable findByFoodItemName(String foodItemName);
}
