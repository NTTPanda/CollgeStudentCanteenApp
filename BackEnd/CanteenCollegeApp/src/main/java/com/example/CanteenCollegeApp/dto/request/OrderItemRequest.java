package com.example.CanteenCollegeApp.dto.request;

public class OrderItemRequest {

    private String foodItem;
    private int quantity;
    private double price;

    // Getters and Setters
    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
