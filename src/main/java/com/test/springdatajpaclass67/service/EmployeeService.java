package com.test.springdatajpaclass67.service;

import com.test.springdatajpaclass67.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    ResponseEntity<EmployeeEntity> createData(EmployeeEntity emp);
}
