package com.test.springdatajpaclass67.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private String message;

    private Integer status;

    private T empData;

}
