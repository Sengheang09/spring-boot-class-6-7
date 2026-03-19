package com.example.springprojectclass67.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {

    @NotBlank(message = "Category name is required")
    private String name;

    @Size(max = 500 , message = "Description must be less than 500 characters")
    private String description;
}
