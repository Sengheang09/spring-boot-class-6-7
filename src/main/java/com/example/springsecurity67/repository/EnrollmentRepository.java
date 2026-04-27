package com.example.springsecurity67.repository;

import com.example.springsecurity67.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findByStudentUserUsername(String username);
}
