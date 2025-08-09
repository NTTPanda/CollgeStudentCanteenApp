package com.example.CanteenCollegeApp.model;

import com.example.CanteenCollegeApp.Enum.FoodCategory;
import jakarta.persistence.*;


@Entity
public class MenuTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String foodItemName;

    private double price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    // Constructors
    public MenuTable() {
    }

    public MenuTable(String foodItemName, double price, int quantity, FoodCategory category) {
        this.foodItemName = foodItemName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }
}
