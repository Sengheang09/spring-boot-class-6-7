package com.test.springdatajpaclass67.service.Impl;

import com.test.springdatajpaclass67.entity.ApiResponse;
import com.test.springdatajpaclass67.entity.EmployeeEntity;
import com.test.springdatajpaclass67.repo.EmployeeRepository;
import com.test.springdatajpaclass67.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repo = repo;
    }
    @Override
    public ResponseEntity<ApiResponse<EmployeeEntity>> createData(EmployeeEntity emp) {

        boolean exist = repo.existsByEmail(emp.getEmail());

        if(exist){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(
                    "This user already have in system",
                    409,
                    null
            ));
        }

        EmployeeEntity employee = repo.save(emp);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                "Data has been added successfully",
                200,
                employee

        ));
    }
}
