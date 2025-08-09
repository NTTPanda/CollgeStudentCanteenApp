package com.example.CanteenCollegeApp.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int studentId;

        private String usn; // changed from USN to usn
        private String name;
        private String branch;
        private Double balance;
        private String password;

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
        private List<Order> orders;

        public Student() {}

    // Constructor with all fields
    public Student(int studentId, String usn, String name, String branch, Double balance, String password, List<Order> orders) {
        this.studentId = studentId;
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.balance = balance;
        this.password = password;
        this.orders = orders;
    }



    public int getStudentId() { return studentId; }

        public String getUsn() { return usn; }

        public String getName() { return name; }

        public String getBranch() { return branch; }

        public Double getBalance() { return balance; }

        public String getPassword() { return password; }

        public List<Order> getOrders() { return orders; }

        public void setStudentId(int studentId) { this.studentId = studentId; }

        public void setUsn(String usn) { this.usn = usn; }

        public void setName(String name) { this.name = name; }

        public void setBranch(String branch) { this.branch = branch; }

        public void setPassword(String password) { this.password = password; }

        public void setBalance(Double balance) { this.balance = balance; }

        public void setOrders(List<Order> orders) { this.orders = orders; }
    }


