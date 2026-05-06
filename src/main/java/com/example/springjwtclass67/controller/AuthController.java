package com.example.springjwtclass67.controller;

import com.example.springjwtclass67.dto.AuthResponse;
import com.example.springjwtclass67.dto.LoginRequest;
import com.example.springjwtclass67.entity.User;
import com.example.springjwtclass67.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        authService.register(user);
        return "Register Success";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        return new AuthResponse(authService.login(request));
    }
}



