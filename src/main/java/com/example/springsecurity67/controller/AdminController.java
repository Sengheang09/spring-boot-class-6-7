package com.example.springsecurity67.controller;

import com.example.springsecurity67.entity.Student;
import com.example.springsecurity67.entity.User;
import com.example.springsecurity67.repository.StudentRepository;
import com.example.springsecurity67.repository.UserRepository;
import dto.StudentRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/students")
public class AdminController {
    private StudentRepository studentRepository;
    private UserRepository userRepository;

    public AdminController(
            StudentRepository studentRepository,
            UserRepository userRepository
    ) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(
            @RequestBody StudentRequestDto request
    ) {
        User user = new User();

        user.setUsername(randomName(request.getFullName()));
        user.setRole("ROLE_STUDENT");
        user.setPassword("{noop}1234");
        user.setEnabled(true);

        userRepository.save(user);

        Student student = new Student();

        student.setFullName(request.getFullName());
        student.setGender(request.getGender());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setUser(user);

        studentRepository.save(student);

        return student;
    }

    private String randomName(String userName){
        String random = userName.toLowerCase()
                .replace(" ","")
                + (int)(Math.random() * 1000);

        return random;
    }


}
