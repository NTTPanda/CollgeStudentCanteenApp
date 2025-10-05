package com.example.CanteenCollegeApp.controller;

import com.example.CanteenCollegeApp.dto.request.PasswordUpdateRequest;
import com.example.CanteenCollegeApp.dto.request.StudentRequest;
import com.example.CanteenCollegeApp.model.Order;
import com.example.CanteenCollegeApp.Service.StudentService;
import com.example.CanteenCollegeApp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;



    @PostMapping("/add")
    public String addNewStudent(@RequestBody StudentRequest studentRequest){
        return studentService.addNewStudent(studentRequest);
    }

    @PutMapping("/modify")
    public String modifyPassword(@RequestBody PasswordUpdateRequest request) {
        return studentService.modifyPassword(request.getUsn(), request.getNewPassword());
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String usn) {
        return studentService.deleteStudent(usn);
    }

    @PutMapping("/add-amount")
    public String addAmount(@RequestParam String usn, @RequestParam Double amount) {
        return studentService.addAmount(usn, amount);
    }

    @PostMapping("/{usn}/orders")
    public String addOrder(@PathVariable String usn, @RequestBody Order order) {
        return studentService.addOrderToStudent(usn, order);
    }

    @GetMapping("/getBalance/{usn}")
    public Map<String, Object> getBalancebyUsn(@PathVariable String usn){
        return studentService.getBalanceResponseByUsn(usn);
    }



    @PutMapping("/updateBalance/{usn}/{totalAmount}")
    public String updateBalanceByUsn(@PathVariable String usn, @PathVariable Double totalAmount) {
        return studentService.updateBalanceByUsn(usn, totalAmount);
    }
}
