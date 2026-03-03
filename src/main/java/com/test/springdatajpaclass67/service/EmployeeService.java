package com.test.springdatajpaclass67.service;

import com.test.springdatajpaclass67.entity.ApiResponse;
import com.test.springdatajpaclass67.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    ResponseEntity<ApiResponse<EmployeeEntity>> createData(EmployeeEntity emp);

    ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllData();

    ResponseEntity<ApiResponse<Optional<EmployeeEntity>>> findById(Long id);

    ResponseEntity<?> updateData(Long id, EmployeeEntity emp);

    ResponseEntity<?> deleteData(Long id);
}
