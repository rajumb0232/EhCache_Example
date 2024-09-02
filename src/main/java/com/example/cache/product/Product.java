package com.example.cache.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private String price;
}
