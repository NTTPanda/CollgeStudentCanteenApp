package com.example.CanteenCollegeApp.controller;

import com.example.CanteenCollegeApp.dto.request.AdminLoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allow requests from frontend
public class AdminLoginController {

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin123";


    @PostMapping("/admin-login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String password = request.get("password");

        System.out.println("Received: name = " + name + ", password = " + password);

        if ("admin".equals(name) && "admin123".equals(password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody Map<String, String> map) {
        return ResponseEntity.ok("Received: " + map.get("name") + ", " + map.get("password"));
    }
}
