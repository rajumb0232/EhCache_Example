package com.example.cache.cache;

import com.example.cache.product.Product;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.spi.CachingProvider;

@Configuration
//@EnableCaching
public class CacheConfig {

//    @Bean
    CacheManager cacheManager() {
        CacheConfiguration<String, Product> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        String.class, Product.class, ResourcePoolsBuilder.heap(100))
                .build();

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("product_cache", cacheConfiguration)
                .build(true);
        return null;
    }
}
