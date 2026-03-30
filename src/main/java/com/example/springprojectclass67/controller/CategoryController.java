package com.example.springprojectclass67.controller;

import com.example.springprojectclass67.dto.requestDto.CategoryRequestDto;
import com.example.springprojectclass67.dto.responseDto.CategoryResponseDto;
import com.example.springprojectclass67.service.CategoryService;
import com.example.springprojectclass67.service.Impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    CategoryServiceImpl categoryService;
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponseDto createCategory(
            @Valid @RequestBody CategoryRequestDto categoryRequestDto
    ) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDto requestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

        categoryService.deleteCategory(id);

        return ResponseEntity.ok("Category deleted successfully");
    }

}
