package com.example.springprojectclass67.service.Impl;

import com.example.springprojectclass67.config.ImageConfig;
import com.example.springprojectclass67.dto.requestDto.ProductRequestDto;
import com.example.springprojectclass67.dto.responseDto.ProductResponseDto;
import com.example.springprojectclass67.entity.Category;
import com.example.springprojectclass67.entity.Product;
import com.example.springprojectclass67.exception.ResourceNotFoundException;
import com.example.springprojectclass67.repo.CategoryRepository;
import com.example.springprojectclass67.repo.ProductRepository;
import com.example.springprojectclass67.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    ImageConfig imageConfig;
    public ProductServiceImpl(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            ImageConfig imageConfig
    ) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.imageConfig = imageConfig;
    }


    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Category id not found : "+requestDto.getCategoryId()));

        Product product = new Product();

        product.setName(requestDto.getName());
        product.setPrice(requestDto.getPrice());

        String imagePath = imageConfig.saveImage(requestDto.getImageUrl());

        product.setImageUrl(imagePath);
        product.setStock(requestDto.getStock());
        product.setDescription(requestDto.getDescription());
        product.setCategory(category);

        Product saved = productRepository.save(product);


        return mapToResponse(saved);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("this product not found : "+id));
        return mapToResponse(product);
    }

    @Override
    public ProductResponseDto mapToResponse(Product product) {
        ProductResponseDto productResponse = new ProductResponseDto();

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setImageUrl(product.getImageUrl());
        productResponse.setStock(product.getStock());
        productResponse.setDescription(product.getDescription());

        productResponse.setCategoryId(product.getCategory().getId());
        productResponse.setCategoryName(product.getCategory().getName());

        return productResponse;
    }
}
