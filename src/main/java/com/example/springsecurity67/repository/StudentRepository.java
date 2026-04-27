package com.example.springsecurity67.repository;

import com.example.springsecurity67.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
