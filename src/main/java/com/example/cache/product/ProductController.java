package com.example.cache.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }
}
