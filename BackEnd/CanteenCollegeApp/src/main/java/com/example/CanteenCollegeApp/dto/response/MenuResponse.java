package com.example.CanteenCollegeApp.dto.response;


import com.example.CanteenCollegeApp.Enum.FoodCategory;

public class MenuResponse {
    private String foodItemName;
    private double price;
    private int quantity;
    private FoodCategory category;

    public MenuResponse() {
    }

    public MenuResponse(String foodItemName, double price, int quantity, FoodCategory category) {
        this.foodItemName = foodItemName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
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
