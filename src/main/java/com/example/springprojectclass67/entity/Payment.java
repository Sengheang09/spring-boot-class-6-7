package com.example.springprojectclass67.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;


    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false )
    private String method;

    @Column(nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(name = "order_id" , unique = true)
    private Orders order;


}
