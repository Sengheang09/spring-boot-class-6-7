package com.test.springdatajpaclass67.service.Impl;

import com.test.springdatajpaclass67.entity.ApiResponse;
import com.test.springdatajpaclass67.entity.EmployeeEntity;
import com.test.springdatajpaclass67.repo.EmployeeRepository;
import com.test.springdatajpaclass67.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllData() {
        List<EmployeeEntity> emps = repo.findAll();

        if(emps.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(
                    "Not found.",
                    404,
                    null
            ));
        }

        return ResponseEntity.ok().body(new ApiResponse<>(
                "Found .",
                200,
                emps
        ));
    }

    @Override
    public ResponseEntity<ApiResponse<Optional<EmployeeEntity>>> findById(Long id) {
        Optional<EmployeeEntity> emp = repo.findById(id);

        if(emp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(
                    "id "+id+" not found",
                    404,
                    null
            ));
        }

        return ResponseEntity.ok().body(new ApiResponse<>(
                "Found",
                200,
                emp
        ));
    }

    @Override
    public ResponseEntity<?> updateData(Long id, EmployeeEntity emp) {
        Optional<EmployeeEntity> employee = repo.findById(id);

        if(employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(
                    "Invalid Id: "+id,
                    404,
                    null
            ));
        }

        EmployeeEntity emplo = employee.get();

        emplo.setName(emp.getName());
        emplo.setGender(emp.getGender());
        emplo.setEmail(emp.getEmail());
        emplo.setSalary(emp.getSalary());

        EmployeeEntity saved = repo.save(emplo);

        return ResponseEntity.ok().body(new ApiResponse<>(
                "Success",
                200,
                saved
        ));
    }

    @Override
    public ResponseEntity<?> deleteData(Long id) {

        Optional<EmployeeEntity> emp = repo.findById(id);

        if(emp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Id: "+id);
        }

        repo.deleteById(id);


        return ResponseEntity.ok().body(new ApiResponse<>(
                "Data has been deleted successfully",
                200,
                emp
        ));
    }

}
