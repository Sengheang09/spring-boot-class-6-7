package com.test.springdatajpaclass67.controller;

import com.test.springdatajpaclass67.entity.ApiResponse;
import com.test.springdatajpaclass67.entity.EmployeeEntity;
import com.test.springdatajpaclass67.repo.EmployeeRepository;
import com.test.springdatajpaclass67.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl empService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeEntity>> postData(
            @RequestBody EmployeeEntity emp
    ) {
        return empService.createData(emp);
    }
}
