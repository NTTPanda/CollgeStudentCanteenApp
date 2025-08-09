package com.example.CanteenCollegeApp.controller;

import com.example.CanteenCollegeApp.model.Student;
import com.example.CanteenCollegeApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class StudentLoginController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student-login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String usn = request.get("usn");
        String password = request.get("password");

        System.out.println("Student Login Request: USN = " + usn + ", Password = " + password);

        Student student = studentRepository.findByUsnAndPassword(usn, password);
        if (student != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid student credentials");
        }
    }
}
