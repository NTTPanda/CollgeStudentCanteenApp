package com.example.CanteenCollegeApp.dto.request;

public class PasswordUpdateRequest {
    private String usn;
    private String newPassword;

    // Constructors
    public PasswordUpdateRequest() {}

    public PasswordUpdateRequest(String usn, String newPassword) {
        this.usn = usn;
        this.newPassword = newPassword;
    }

    // Getters and Setters
    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
