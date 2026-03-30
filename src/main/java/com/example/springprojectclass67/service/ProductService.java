package com.example.springprojectclass67.service;

import com.example.springprojectclass67.dto.requestDto.ProductRequestDto;
import com.example.springprojectclass67.dto.responseDto.ProductResponseDto;
import com.example.springprojectclass67.entity.Product;
import io.swagger.v3.oas.annotations.servers.Server;

import java.util.List;

@Server
public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto requestDto);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto findProductById(Long id);

    ProductResponseDto mapToResponse(Product product);
}
