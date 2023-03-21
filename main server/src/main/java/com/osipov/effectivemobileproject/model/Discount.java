package com.osipov.effectivemobileproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "discounts_products",
            joinColumns = @JoinColumn(name = "discount_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @Column(name = "discount_percentage", nullable = false)
    private Double discountPercentage;
    @Column(name = "start_discount", nullable = false)
    private LocalDateTime startDiscount;
    @Column(name = "finish_discount", nullable = false)
    private LocalDateTime finishDiscount;
    @Column(name = "date_of_creation", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dateOfCreation;
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;
}