package com.example.springsecurity67.controller;

import dto.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiAuthController {

    private final AuthenticationManager authenticationManager;
    public ApiAuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/csrf")
    public Map<String , String> csrf(CsrfToken csrfToken) {

        Map<String , String> map = new HashMap<>();

        map.put("Token", csrfToken.getToken());
        map.put("HeaderCsrfToken", csrfToken.getHeaderName());
        map.put("parameterName", csrfToken.getParameterName());

        return map;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest ,
            HttpServletRequest request
    ) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        request.getSession(true).setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                context
        );

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Login Success");
        response.put("Username" , authentication.getName());
        response.put("Authorities" , authentication.getAuthorities());

        return ResponseEntity.ok(response);
    }

}
