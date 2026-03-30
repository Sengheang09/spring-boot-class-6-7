package com.example.springprojectclass67.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ValidationExceptionHandler(MethodArgumentNotValidException e) {

        Map<String , String> error = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(
                err -> error.put(err.getField(), err.getDefaultMessage())
        );

        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String , String> error = new HashMap<>();

        error.put("error" , ex.getMessage());

        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }
}
