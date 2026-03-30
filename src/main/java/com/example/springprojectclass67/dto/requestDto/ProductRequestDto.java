package com.example.springprojectclass67.dto.requestDto;

import com.example.springprojectclass67.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotNull(message = "product name is required")
    private String name;

    @NotNull(message = "price is required")
    private BigDecimal price;

    private MultipartFile imageUrl;

    @NotNull(message = "stock must added")
    private Integer stock;

    @Size(max = 1000 , message = "description must be less than 1000 characters")
    private String description;

    @NotNull(message = "Category id is required")
    private Long categoryId;
}
