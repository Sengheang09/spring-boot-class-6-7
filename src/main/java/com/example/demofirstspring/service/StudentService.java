package com.example.demofirstspring.service;

import com.example.demofirstspring.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface StudentService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> createData(Student student);
}
