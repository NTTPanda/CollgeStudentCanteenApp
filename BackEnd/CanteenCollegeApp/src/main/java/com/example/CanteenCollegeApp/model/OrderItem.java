package com.example.CanteenCollegeApp.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String foodItem;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    // Constructors
    public OrderItem() {}

    public OrderItem(String foodItem, int quantity, double price, Order order) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    // Getters and Setters
    public int getId() { return id; }

    public String getFoodItem() { return foodItem; }
    public void setFoodItem(String foodItem) { this.foodItem = foodItem; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
