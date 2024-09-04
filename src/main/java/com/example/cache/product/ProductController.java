package com.example.cache.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.cache.annotation.CachePut;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    public String verifyOTP(OtpRequest otpRequest){
        return productService.verifyOTP(otpRequest);
    }

    @GetMapping
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/{productId}")
    public Product findProductById(int productId){
        return productService.findProductById(productId);
    }
}
