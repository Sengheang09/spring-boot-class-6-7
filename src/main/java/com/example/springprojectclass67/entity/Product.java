package com.example.springprojectclass67.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "products")
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

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

}
