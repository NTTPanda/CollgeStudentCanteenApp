package com.example.CanteenCollegeApp.transformer;


import com.example.CanteenCollegeApp.dto.request.StudentRequest;
import com.example.CanteenCollegeApp.model.Student;

public class StudentTransformer {

    public static Student convertRequestToStudent(StudentRequest request) {
        Student student = new Student();
        student.setUsn(request.getUsn());
        student.setName(request.getName());
        student.setBranch(request.getBranch());
        student.setBalance(request.getBalance());
        student.setPassword(request.getPassword());
        return student;
    }
}
