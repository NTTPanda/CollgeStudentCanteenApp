package com.example.CanteenCollegeApp.dto.response;

public class OrderItemSummaryDTO {
    private int tableNumber;
    private String foodItem;
    private double price;
    private int quantity;

    public OrderItemSummaryDTO(int tableNumber, String foodItem, double price, int quantity) {
        this.tableNumber = tableNumber;
        this.foodItem = foodItem;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters (Setters optional if you need)
    public int getTableNumber() { return tableNumber; }
    public String getFoodItem() { return foodItem; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
