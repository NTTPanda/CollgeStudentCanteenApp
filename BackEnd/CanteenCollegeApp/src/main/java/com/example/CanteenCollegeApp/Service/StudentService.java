package com.example.CanteenCollegeApp.Service;


import com.example.CanteenCollegeApp.dto.request.StudentRequest;
import com.example.CanteenCollegeApp.model.MenuTable;
import com.example.CanteenCollegeApp.model.Order;
import com.example.CanteenCollegeApp.model.Student;
import com.example.CanteenCollegeApp.repository.StudentRepository;
import com.example.CanteenCollegeApp.repository.OrderRepository;
import com.example.CanteenCollegeApp.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public String addNewStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByUsn(studentRequest.getUsn())) {
            return "Student with USN " + studentRequest.getUsn() + " already exists.";
        }

        Student student = StudentTransformer.convertRequestToStudent(studentRequest);
        studentRepository.save(student);

        return "Student added successfully.";
    }

    public String modifyPassword(String usn, String newPassword) {
        Optional<Student> optionalStudent = studentRepository.findByUsn(usn);

        if (optionalStudent.isEmpty()) {
            return "Student with USN " + usn + " not present.";
        }

        Student student = optionalStudent.get();
        student.setPassword(newPassword);
        studentRepository.save(student);

        return "Password updated successfully for USN " + usn + ".";
    }



    public String deleteStudent(String usn) {
        Optional<Student> optionalStudent = studentRepository.findByUsn(usn);

        if (optionalStudent.isEmpty()) {
            return "Student with USN " + usn + " not found.";
        }

        studentRepository.delete(optionalStudent.get());
        return "Student with USN " + usn + " deleted successfully.";
    }


    public String addAmount(String usn, Double amount) {
        Optional<Student> optionalStudent = studentRepository.findByUsn(usn);
        if (optionalStudent.isEmpty()) {
            return "Student with USN " + usn + " not found.";
        }
        Student student = optionalStudent.get();
        Double currentBalance = student.getBalance();
        student.setBalance(currentBalance + amount);
        studentRepository.save(student);

        return "Amount of ₹" + amount + " added successfully to USN " + usn +
                ". New Balance: ₹" + student.getBalance();
    }

    public String addOrderToStudent(String usn, Order order) {
        Optional<Student> optionalStudent = studentRepository.findByUsn(usn);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            order.setStudent(student);  // associate student
            orderRepository.save(order); // save order

            if (student.getOrders() == null) {
                student.setOrders(new ArrayList<>());
            }
            student.getOrders().add(order);
            studentRepository.save(student);

            return "Order added successfully for student with USN: " + usn;
        } else {
            return "Student with USN: " + usn + " not found.";
        }
    }



    public Map<String, Object> getBalanceResponseByUsn(String usn) {
        Map<String, Object> response = new HashMap<>();
        Optional<Student> optionalStudent = studentRepository.findByUsn(usn);

        if (optionalStudent.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Student with USN " + usn + " not found.");
            return response;
        }

        Student student = optionalStudent.get();
        response.put("status", "success");
        response.put("usn", usn);
        response.put("balance", student.getBalance());
        return response;
    }

    public String updateBalanceByUsn(String usn ,Double totalAmount) {
        Optional<Student> optionalStudent = studentRepository.findByUsn(usn);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            double updatedBalance = student.getBalance()-totalAmount;
            student.setBalance(updatedBalance);
            studentRepository.save(student);
            return "Success";
        }
        else{
            return "Failed";
        }
    }
}