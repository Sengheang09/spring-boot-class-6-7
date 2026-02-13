package com.example.demofirstspring.service.Impl;

import com.example.demofirstspring.entity.Student;
import com.example.demofirstspring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1002 , "John" , "Male"),
                    new Student(1003 , "Joe" , "Female")
            )
    );

    @Override
    public ResponseEntity<?> getAll() {
        if(students.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Have no data.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(students);
    }

    @Override
    public ResponseEntity<?> createData(Student student) {
        boolean exist = students.stream().anyMatch(s -> s.getId().equals(student.getId()));
        if(exist){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This Data Already Exist");
        }

        if(!student.getName().matches("^[a-z A-z]+$")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name Must Be Character");
        }

        if(!(student.getName().length() > 5 && student.getName().length()<30)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name Must be 5 to 30 characters");
        }

        if(
                !(student.getGender().equalsIgnoreCase("male") ||
                        student.getGender().equalsIgnoreCase("Female")))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gender must be male and female");
        }

        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
