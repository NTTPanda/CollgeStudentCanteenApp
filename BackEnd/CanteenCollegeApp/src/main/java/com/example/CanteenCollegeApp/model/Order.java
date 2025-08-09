package com.example.CanteenCollegeApp.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int tableNumber;
    private int amount;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;


    private String date;
    private String time;

    // Constructors
    public Order() {}

    public Order(Student student, int tableNumber, List<OrderItem> orderItems,int amount,String date,String time) {
        this.student = student;
        this.tableNumber = tableNumber;
        this.orderItems = orderItems;
        this.amount=amount;
        this.date=date;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }

    public int getAmount() {
        return amount;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
}
