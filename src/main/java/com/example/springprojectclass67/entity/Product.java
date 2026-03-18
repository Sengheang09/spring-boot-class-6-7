package com.example.springprojectclass67.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "image_url" , nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false , columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id" )
    private Category category;

}
