package com.test.springdatajpaclass67.service.Impl;

import com.test.springdatajpaclass67.entity.EmployeeEntity;
import com.test.springdatajpaclass67.repo.EmployeeRepository;
import com.test.springdatajpaclass67.service.EmployeeService;
import org.springframework.http.ResponseEntity;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repo = repo;
    }
    @Override
    public ResponseEntity<EmployeeEntity> createData(EmployeeEntity emp) {
        EmployeeEntity employee = repo.save(emp);

        return ResponseEntity.ok().body(employee);
    }
}
