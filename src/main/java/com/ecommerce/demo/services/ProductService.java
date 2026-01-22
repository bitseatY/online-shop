package com.ecommerce.demo.services;

import com.ecommerce.demo.repositories.CategoryRepository;
import com.ecommerce.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

}
