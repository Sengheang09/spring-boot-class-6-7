package com.example.demofirstspring.controller;

import com.example.demofirstspring.entity.Student;
import com.example.demofirstspring.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl service;

    @GetMapping
    public ResponseEntity<?> showAll(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student){
        return service.createData(student);
    }

}
