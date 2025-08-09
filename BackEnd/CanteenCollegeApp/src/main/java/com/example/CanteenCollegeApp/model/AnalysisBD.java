package com.example.CanteenCollegeApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnalysisBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dataId;

    private String date;
    private String time;
    private String foodItemName;
    private double price;
    private int quantity;
    private double totalAmount;


    // Constructors
    public AnalysisBD() {}

    public AnalysisBD(String date, String time, String foodItemName, double price, int quantity) {
        this.date = date;
        this.time = time;
        this.foodItemName = foodItemName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = price * quantity; // optional initialization
    }

    // Getters and Setters
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
