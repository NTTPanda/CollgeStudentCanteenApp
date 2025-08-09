package com.example.CanteenCollegeApp.repository;


import com.example.CanteenCollegeApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUsnAndPassword(String usn, String password);

    // Check if student exists by USN
    boolean existsByUsn(String usn);

    // ✅ Use Optional version
    Optional<Student> findByUsn(String usn);

}
