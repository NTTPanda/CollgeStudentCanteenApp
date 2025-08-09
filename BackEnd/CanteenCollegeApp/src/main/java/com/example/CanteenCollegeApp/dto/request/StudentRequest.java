package com.example.CanteenCollegeApp.dto.request;

public class StudentRequest {

    private String usn;
    private String name;
    private String branch;
    private Double balance;
    private String password;

    public StudentRequest() {
    }

    public StudentRequest(String usn, String name, String branch, Double balance, String password) {
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.balance = balance;
        this.password = password;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
