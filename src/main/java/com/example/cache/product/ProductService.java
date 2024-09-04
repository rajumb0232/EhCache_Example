package com.example.cache.product;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepo;

    @CachePut(cacheNames = "product", key = "#product.productId")
    public Product saveProduct(Product product) {
        int otp = this.getOTP(product.getProductId());
        System.err.println(otp);
        return productRepo.save(product);
    }

    @Cacheable(cacheNames = "otps", key = "#productId")
    private Integer getOTP(int productId) {
        if(productId > 0){
            Random random = new SecureRandom();
            return random.nextInt(100000,999999);
        } else return 0;
    }

    public String verifyOTP(OtpRequest otpRequest) {
        System.out.println(findProductById(otpRequest.getOtp()));
        System.out.println(otpRequest.getOtp());
        return String.valueOf(otpRequest.getOtp());
    }

    @Cacheable(cacheNames = "products")
    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    @Cacheable(cacheNames = "product", key = "#productId")
    public Product findProductById(int productId){
        return productRepo.findById(productId).orElse(null);
    }

}
