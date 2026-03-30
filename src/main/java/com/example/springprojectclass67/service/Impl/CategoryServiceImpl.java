package com.example.springprojectclass67.service.Impl;

import com.example.springprojectclass67.dto.requestDto.CategoryRequestDto;
import com.example.springprojectclass67.dto.responseDto.CategoryResponseDto;
import com.example.springprojectclass67.entity.Category;
import com.example.springprojectclass67.exception.ResourceNotFoundException;
import com.example.springprojectclass67.repo.CategoryRepository;
import com.example.springprojectclass67.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;

@Service
public class CategoryServiceImpl implements CategoryService {

    public final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = new Category();

        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());

        Category saved = categoryRepository.save(category);

        return mapToResponse(saved);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(this::mapToResponse)
                .toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return mapToResponse(category);
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());

        Category updated = categoryRepository.save(category);

        return mapToResponse(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        categoryRepository.deleteById(id);
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
