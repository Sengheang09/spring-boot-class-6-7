package com.test.springdatajpaclass67.controller;

import com.test.springdatajpaclass67.entity.ApiResponse;
import com.test.springdatajpaclass67.entity.EmployeeEntity;
import com.test.springdatajpaclass67.repo.EmployeeRepository;
import com.test.springdatajpaclass67.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAll(){
        return empService.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<EmployeeEntity>>> getById(@PathVariable Long id){
        return empService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody EmployeeEntity emp
    ){
        return empService.updateData(id, emp);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return empService.deleteData(id);
    }

}
