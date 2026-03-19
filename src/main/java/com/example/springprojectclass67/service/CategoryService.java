package com.example.springprojectclass67.service;

import com.example.springprojectclass67.dto.requestDto.CategoryRequestDto;
import com.example.springprojectclass67.dto.responseDto.CategoryResponseDto;
import com.example.springprojectclass67.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto getCategoryById(Long id);

    CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto);

    void deleteCategory(Long id);

    CategoryResponseDto mapToResponse(Category category);
}
