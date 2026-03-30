package com.example.springprojectclass67.dto.responseDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String name;

    private BigDecimal price;

    private String imageUrl;

    private Integer stock;

    private String description;

    private Long categoryId;

    private String categoryName;

}
