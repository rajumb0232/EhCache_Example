package com.example.cache.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepo;

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }
}
