package com.example.springprojectclass67.service.Impl;

import com.example.springprojectclass67.dto.requestDto.CategoryRequestDto;
import com.example.springprojectclass67.dto.responseDto.CategoryResponseDto;
import com.example.springprojectclass67.entity.Category;
import com.example.springprojectclass67.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        return null;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public CategoryResponseDto mapToResponse(Category category) {
        CategoryResponseDto responseDto = new CategoryResponseDto();

        responseDto.setId(category.getId());
        responseDto.setName(category.getName());
        responseDto.setDescription(category.getDescription());

        return responseDto;
    }
}
